package crystalrevolution.handlers;

import java.util.HashMap;

import crystalrevolution.gameobjs.BaubleRegistration;
import crystalrevolution.gameobjs.ModBlocks;
import crystalrevolution.gameobjs.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.stats.Achievement;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.AchievementPage;

public class AchievementHandler {

	private static AchievementPage crystalPage;
    private static HashMap<String, Achievement> achievementsList = new HashMap<String, Achievement>();
	
    public static void addAchievement(String name, Achievement ach){
    	achievementsList.put(name, ach.registerStat());
    }
    
    public static Achievement getAchievement(String name){
    	return achievementsList.get(name);
    }
    
    public static void triggerAchievement(EntityPlayer p, String name){
    	
    	Achievement ach = getAchievement(name);
    	
    	if(ach != null){
    		p.triggerAchievement(ach);
    	}
    	
    }
    
    public static void addDefaultAchievements(){
    	
    	addAchievement("crystalrevolution.early_stoneage", new Achievement("crystalrevolution.early_stoneage", "crystalrevolution.early_stoneage", 0, 0, Blocks.cobblestone, null).initIndependentStat().setSpecial());
    	addAchievement("crystalrevolution.stoneage", new Achievement("crystalrevolution.stoneage", "crystalrevolution.stoneage", 0, 2, Blocks.stone, getAchievement("crystalrevolution.early_stoneage")));
    	addAchievement("crystalrevolution.copperage", new Achievement("crystalrevolution.copperage", "crystalrevolution.copperage", -2, 2, ModItems.ingotCopper, getAchievement("crystalrevolution.stoneage")));
    	addAchievement("crystalrevolution.bronzeage", new Achievement("crystalrevolution.bronzeage", "crystalrevolution.bronzeage", -2, 4, ModItems.ingotBronze, getAchievement("crystalrevolution.copperage")));
    	addAchievement("crystalrevolution.ringcrafting", new Achievement("crystalrevolution.ringcrafting", "crystalrevolution.ringcrafting", -4, 4, ModBlocks.jewelcraftingTable, getAchievement("crystalrevolution.bronzeage")));
    	addAchievement("crystalrevolution.early_middleage", new Achievement("crystalrevolution.early_middleage", "crystalrevolution.early_middleage", -2, 0, ModItems.ingotBrass, getAchievement("crystalrevolution.bronzeage")));
    	addAchievement("crystalrevolution.middleage", new Achievement("crystalrevolution.middleage", "crystalrevolution.middleage", 0, -3, Items.iron_ingot, getAchievement("crystalrevolution.early_middleage")));
    	addAchievement("crystalrevolution.renaissance", new Achievement("crystalrevolution.renaissance", "crystalrevolution.renaissance", 4, -1, Items.gold_ingot, getAchievement("crystalrevolution.middleage")));
    	    	
    }
    
    public static void registerAchievementPage()
    {
    	
    	Achievement[] ach = new Achievement[achievementsList.size()];
    	
    	ach = achievementsList.values().toArray(ach);
    	crystalPage = new AchievementPage(StatCollector.translateToLocal("crystalrevolution.crystalpage.name"), ach);
    	AchievementPage.registerAchievementPage(crystalPage);
    	
    }
}
