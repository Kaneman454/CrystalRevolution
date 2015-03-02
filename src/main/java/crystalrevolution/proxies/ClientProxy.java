package crystalrevolution.proxies;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import crystalrevolution.Main;
import crystalrevolution.gameobjs.tileentities.TileEntitySmeltery;
import crystalrevolution.handlers.KeyHandler;

public class ClientProxy extends ServerProxy{
		
	public void registerProxies(){
		FMLCommonHandler.instance().bus().register(new KeyHandler());
	}
		
	
	public int addArmor(String armor){
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
	public void registerTileEntities(){
		
	}
}
