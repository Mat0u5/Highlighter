package com.anthonyhilyard.highlighter.forge;

import com.anthonyhilyard.highlighter.Highlighter;

import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(Highlighter.MODID)
public final class HighlighterForge
{
	public HighlighterForge()
	{
		// Run our common setup.
		Highlighter.init();

		ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> "ANY", (remote, isServer) -> true));
	}
}
