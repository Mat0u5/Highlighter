package com.anthonyhilyard.highlighter.forge;

import com.anthonyhilyard.highlighter.Highlighter;

import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
@Mod(Highlighter.MODID)
public final class HighlighterForge
{
	public HighlighterForge(FMLJavaModLoadingContext context)
	{
		context.registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> "ANY", (remote, isServer) -> true));
	}
}
