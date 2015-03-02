package crystalrevolution.utils;

import cpw.mods.fml.common.Loader;

public final class ModHandler {
	private ModHandler(){}
	
	public static final boolean AppliedEnergistics2 = Loader.isModLoaded("appliedenergistics2");
	public static final boolean Baubles = Loader.isModLoaded("Baubles");
	public static final boolean Mekanism = Loader.isModLoaded("Mekanism");
	public static final boolean Thaumcraft = Loader.isModLoaded("Thaumcraft");
	public static final boolean TinkersConstruct = Loader.isModLoaded("TConstruct");
	
}
