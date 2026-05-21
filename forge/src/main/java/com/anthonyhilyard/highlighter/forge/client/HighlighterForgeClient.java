package com.anthonyhilyard.highlighter.forge.client;

import com.anthonyhilyard.highlighter.Highlighter;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

@EventBusSubscriber(modid = Highlighter.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public final class HighlighterForgeClient
{
	@SubscribeEvent
	public static void onConstructMod(final FMLConstructModEvent event)
	{
		Highlighter.init();
	}
}