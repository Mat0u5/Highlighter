package com.anthonyhilyard.highlighter.config;

import java.util.Map;
import java.util.function.Supplier;

import org.apache.commons.lang3.tuple.Pair;

import com.anthonyhilyard.highlighter.Highlighter;
import com.anthonyhilyard.iceberg.config.IcebergConfig;
import com.anthonyhilyard.iceberg.services.IIcebergConfigSpecBuilder;
import com.google.common.collect.Maps;

import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.PatchedDataComponentMap;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class HighlighterConfig extends IcebergConfig<HighlighterConfig>
{
	public static HighlighterConfig getInstance() { return (HighlighterConfig)configInstances.get(Highlighter.MODID); }
	public enum IconPosition
	{
		UpperLeft,
		UpperRight,
		LowerLeft,
		LowerRight
	}

	public final Supplier<Boolean> clearOnInventoryClose;
	public final Supplier<Boolean> clearOnHover;
	public final Supplier<Boolean> clearOnSelect;
	public final Supplier<Boolean> useItemNameColor;
	public final Supplier<Boolean> showOnHotbar;
	public final Supplier<IconPosition> iconPosition;

	private static Map<Pair<Item, DataComponentMap>, TextColor> colorCache = Maps.newHashMap();

	public HighlighterConfig(IIcebergConfigSpecBuilder build)
	{
		build.comment("Client Configuration").push("client").push("options");

		clearOnInventoryClose = build.comment(" If new item markers should be cleared when the inventory is closed.").add("clear_on_close", true);
		clearOnHover = build.comment(" If new item markers should be cleared when the item tooltip is displayed.").add("clear_on_hover", true);
		clearOnSelect = build.comment(" If new item markers should be cleared when the item is selected on the hotbar.").add("clear_on_select", true);
		useItemNameColor = build.comment(" If icons should match the color of items names (as shown in tooltips).  Otherwise icons will all be gold.").add("item_name_color", false);
		showOnHotbar = build.comment(" If new item markers should show on the hotbar.").add("show_on_hotbar", true);
		iconPosition = build.comment(" The position of new item markers.").addEnum("icon_position", IconPosition.UpperLeft);

		build.pop().pop();
	}

	@SuppressWarnings("removal")
	public static TextColor getColorForItem(ItemStack itemStack, TextColor defaultColor)
	{
		Pair<Item, DataComponentMap> key = Pair.of(itemStack.getItem(), new PatchedDataComponentMap(itemStack.getComponents()));
		if (!colorCache.containsKey(key))
		{
			TextColor color = com.anthonyhilyard.iceberg.util.ItemColor.getColorForItem(itemStack, defaultColor);
			colorCache.put(key, color);
		}

		return colorCache.get(key);
	}

	@Override
	protected void onReload()
	{
		// Clear the color cache if the config changes.
		colorCache.clear();
	}
}