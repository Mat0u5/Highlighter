package com.anthonyhilyard.highlighter.forge.mixin;

import com.anthonyhilyard.highlighter.Highlighter;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.network.chat.Component;

@Mixin(AbstractContainerScreen.class)
public class AbstractContainerScreenMixin extends Screen
{
	protected AbstractContainerScreenMixin(Component titleIn) { super(titleIn); }

	@Inject(method = "extractSlot", remap = false, at = @At(value = "INVOKE",
			target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;itemDecorations(Lnet/minecraft/client/gui/Font;Lnet/minecraft/world/item/ItemStack;IILjava/lang/String;)V", shift = Shift.AFTER))
	public void renderSlot(GuiGraphicsExtractor graphics, Slot slot, int m, int n, CallbackInfo ci)
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
