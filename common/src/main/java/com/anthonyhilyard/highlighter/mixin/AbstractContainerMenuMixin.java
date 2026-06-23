package com.anthonyhilyard.highlighter.mixin;

import net.minecraft.world.inventory.ContainerInput;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import com.anthonyhilyard.highlighter.Highlighter;
import net.minecraft.world.inventory.InventoryMenu;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractContainerMenu.class)
public class AbstractContainerMenuMixin
{
	@Inject(method = "doClick", at = @At("HEAD"))
	public void doClick(int slotIndex, int buttonNum, ContainerInput containerInput, Player player, CallbackInfo ci)
	{
		if ((Object)this instanceof InventoryMenu)
		{
			Highlighter.itemClicked(slotIndex);
		}
	}
}