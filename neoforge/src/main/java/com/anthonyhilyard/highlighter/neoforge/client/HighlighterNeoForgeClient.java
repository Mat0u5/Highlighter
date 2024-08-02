package com.anthonyhilyard.highlighter.neoforge.client;

import com.anthonyhilyard.highlighter.Highlighter;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = Highlighter.MODID, dist = Dist.CLIENT)
public final class HighlighterNeoForgeClient
{
	public HighlighterNeoForgeClient()
	{
		Highlighter.init();
	}
}

