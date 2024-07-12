package com.anthonyhilyard.highlighter.neoforge;

import com.anthonyhilyard.highlighter.Highlighter;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Highlighter.MODID)
public final class HighlighterNeoForge
{
	public HighlighterNeoForge(ModContainer container, IEventBus modBus)
	{
		// Run our common setup.
		Highlighter.init();
	}
}

