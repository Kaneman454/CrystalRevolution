package crystalrevolution.utils;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import crystalrevolution.Main;
import crystalrevolution.gameobjs.tileentities.TileEntitySmeltery;
import crystalrevolution.handlers.GuiHandler;

public class TileEntities {

	public static void loadTileEntities(){
		registerTileEntities();
	}
	
	private static void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntitySmeltery.class, "Smeltery");
	}
	
}
