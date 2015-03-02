package crystalrevolution.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import crystalrevolution.libs.LibMisc;

public class CrystalConfig {

	public static String ModConfigurationDirectory = "";
	private static final String[] DEFAULT_RECIPE_LIST = {"minecraft:stone", "modid:item"};
	public static String[] recipeList;
	
	public static Configuration recipeConfig;
	public static Configuration itemConfig;
	
	public static boolean enableBackpack = true;
		
	public static void initializeConfiguration(String configDirectory){
		
		ModConfigurationDirectory = configDirectory;
		
		File file;
		
		file = new File(ModConfigurationDirectory, "CrystalRevolution/Items.cfg");
		itemConfig = new Configuration(file);
		
		file = new File(ModConfigurationDirectory, "CrystalRevolution/Recipe.cfg");
		recipeConfig = new Configuration(file);
		
		
		
		loadConfigs();
		
	}
		
	public static void loadConfigs(){
		LibMisc.logger.info("[Crystal Revolution]: Load Item Config");
		loadItemConfig();
		LibMisc.logger.info("[Crystal Revolution]: Load RecipeRemove Config");
		loadRecipeRemoveConfig();
	}
	
	private static void loadRecipeRemoveConfig(){
		if(recipeConfig == null){
			return;
		}
		
		Property recipeList = recipeConfig.get("Remove Recipes", "disabledRecipes", DEFAULT_RECIPE_LIST);
		String[] recipeListS = recipeList.getStringList();
		recipeList.comment = "Place the block ID on each separate line. \n Use the /id command in-game to get the block/item IDs.";
		
		if(recipeConfig.hasChanged() == true){
			LibMisc.logger.info("[Crystal Revolution]: Recipe config was changed. Saving changes!");
			recipeConfig.save();
			LibMisc.logger.info("[Crystal Revolution]: Recipe config was changed. Saving changes!");
		}
		
		CrystalConfig.recipeList = recipeListS;
	}
	
	private static void loadItemConfig(){
		
		if(itemConfig == null){
			return;
		}
		
		Property enableBackpacks = itemConfig.get("Item", "Enable Backpacks", enableBackpack);
		enableBackpacks.comment = String.format("Option to enable Backpacks (default: %s)", new Object[]{ Boolean.valueOf(enableBackpack)});
		enableBackpack = enableBackpacks.getBoolean(enableBackpack);		
		
	    if (itemConfig.hasChanged() == true) {
	    	LibMisc.logger.info("[Crystal Revolution]: Item config was changed. Saving changes!");
	    	itemConfig.save();
	    	LibMisc.logger.info("[Crystal Revolution]: Item config has been saved");
	      }
		
	}
	
	
}
