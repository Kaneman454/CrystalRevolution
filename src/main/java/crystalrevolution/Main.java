package crystalrevolution;

import net.minecraftforge.common.AchievementPage;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import crystalrevolution.cmds.getIDCommand;
import crystalrevolution.cmds.getIDFromHandCommand;
import crystalrevolution.config.CrystalConfig;
import crystalrevolution.gameobjs.BaubleRegistration;
import crystalrevolution.gameobjs.ModBlocks;
import crystalrevolution.gameobjs.ModItems;
import crystalrevolution.gameobjs.recipes.RecipeManager;
import crystalrevolution.gameobjs.recipes.RecipeRemover;
import crystalrevolution.handlers.AchievementHandler;
import crystalrevolution.handlers.GuiHandler;
import crystalrevolution.handlers.HarvestLevelHandler;
import crystalrevolution.handlers.EEventHandler;
import crystalrevolution.libs.LibMisc;
import crystalrevolution.proxies.ClientProxy;
import crystalrevolution.utils.ModHandler;
import crystalrevolution.utils.TileEntities;

@Mod(modid = LibMisc.MOD_ID, version = LibMisc.VERSION, name = LibMisc.MOD_NAME, acceptedMinecraftVersions = "[1.7.10]",  dependencies = LibMisc.MOD_DEPENDENCIES)
public class Main {
		
	public static boolean isHalloween = false;
	public static boolean isChristmas = false;
	
	
	//--ImportantStuff
	@Instance(LibMisc.MOD_ID)
	public static Main instance;
	@SidedProxy(clientSide= LibMisc.PROXY_CLIENT, serverSide= LibMisc.PROXY_SERVER)
	public static ClientProxy proxy;
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		
		loadHandlers();
		LibMisc.packetPipeLine.init();
		CrystalConfig.initializeConfiguration(e.getModConfigurationDirectory().toString());
		RecipeRemover.RecipeRemove();
		loadGameobjs();
		TileEntities.loadTileEntities();
		AchievementHandler.addDefaultAchievements();
	}
	@EventHandler
	public void Init(FMLInitializationEvent e){	
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		RecipeManager.manageRecipes();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		LibMisc.packetPipeLine.postInitialize();
		AchievementHandler.registerAchievementPage();
	}
	
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
      event.registerServerCommand(new getIDCommand());
      event.registerServerCommand(new getIDFromHandCommand());
    }
    
    private void loadHandlers(){

    	HarvestLevelHandler.changeHarvestLevel();
    	
    	FMLCommonHandler.instance().bus().register(new EEventHandler());
    }
	
    private void loadGameobjs(){
		ModBlocks.ladeBloecke();
		ModItems.ladeItems();
		if(ModHandler.Baubles == true){
			BaubleRegistration.registerBaubles();
			if(ModHandler.Thaumcraft == true){
				//TC Integration
			}
		}
		if(ModHandler.AppliedEnergistics2 == true){
			//AE2 Integration
		}
		if(ModHandler.TinkersConstruct == true){
			//Tinkers Integration
		}
    }
}
