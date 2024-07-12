package com.anthonyhilyard.highlighter.fabric;

import com.anthonyhilyard.highlighter.Highlighter;

import net.fabricmc.api.ModInitializer;

public final class HighlighterFabric implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		// Run our common setup.
		Highlighter.init();
	}
}
