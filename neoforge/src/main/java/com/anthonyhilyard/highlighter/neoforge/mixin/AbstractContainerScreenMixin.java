package com.anthonyhilyard.highlighter.neoforge.mixin;

import com.anthonyhilyard.highlighter.Highlighter;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

@Mixin(AbstractContainerScreen.class)
public class AbstractContainerScreenMixin extends Screen
{
	protected AbstractContainerScreenMixin(Component titleIn) { super(titleIn); }

	@Inject(method = "renderSlotContents", at = @At(value = "TAIL"), remap = false)
	public void renderSlotContents(GuiGraphics graphics, ItemStack itemStack, Slot slot, String countString, CallbackInfo info)
	{
		// Only mark items that are in the player's inventory.
		if (slot.container instanceof Inventory)
		{
			if (slot.hasItem() && ((Inventory)slot.container).getNonEquipmentItems().contains(slot.getItem()))
			{
				Highlighter.renderNewItemMark(graphics, slot);
			}
		}
	}
}
