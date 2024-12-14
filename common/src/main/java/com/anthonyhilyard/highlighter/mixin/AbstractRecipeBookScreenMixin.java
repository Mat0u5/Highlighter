package com.anthonyhilyard.highlighter.mixin;

import com.anthonyhilyard.highlighter.Highlighter;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.RecipeBookMenu;
import net.minecraft.network.chat.Component;

@Mixin(AbstractRecipeBookScreen.class)
public abstract class AbstractRecipeBookScreenMixin<T extends RecipeBookMenu> extends AbstractContainerScreen<T>
{
	public AbstractRecipeBookScreenMixin(T abstractContainerMenu, Inventory inventory, Component component)
	{
		super(abstractContainerMenu, inventory, component);
	}

	@Override
	public void onClose()
	{
		super.onClose();
		Highlighter.inventoryClosed();
	}
}
