package crystalrevolution.gameobjs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.world.BlockEvent;
import crystalrevolution.gameobjs.blocks.BlockJewelcraftTable;
import crystalrevolution.gameobjs.blocks.BlockOre;
import crystalrevolution.gameobjs.blocks.BlockSmeltery;
import crystalrevolution.handlers.HarvestLevelHandler;
import crystalrevolution.utils.RegHelper;

public class ModBlocks {
	
	public static Block copperOre;
	public static Block tinOre;
	public static Block zincOre;
	public static Block cobaltOre;
	public static Block rhodiumOre;
	public static Block palladiumOre;
	public static Block osmiumOre;
	public static Block iridiumOre;
	public static Block platinOre;
	public static Block mithrilOre;
	
	public static Block smelteryIdle;
	public static Block smelteryActive;
	
	public static Block jewelcraftingTable;
		
	public static void ladeBloecke(){

		smelteryIdle = new BlockSmeltery(false).setBlockName("smeltery_idle").setCreativeTab(crystalTab.crystalCreativeTab);
		smelteryActive = new BlockSmeltery(true).setBlockName("smeltery_active");
		RegHelper.registerBlock(smelteryIdle);
		RegHelper.registerBlock(smelteryActive);
		
		jewelcraftingTable = new BlockJewelcraftTable().setBlockName("JewelcraftingTable");
		RegHelper.registerBlock(jewelcraftingTable);
		
		copperOre = new BlockOre(Material.rock).setBlockName("copperOre").setBlockTextureName("crystalrevolution:copperOre");
		RegHelper.registerBlock(copperOre);
		tinOre = new BlockOre(Material.rock).setBlockName("tinOre").setBlockTextureName("crystalrevolution:tinOre");
		RegHelper.registerBlock(tinOre);
		zincOre = new BlockOre(Material.rock).setBlockName("zincOre").setBlockTextureName("crystalrevolution:zincOre");
		RegHelper.registerBlock(zincOre);
		cobaltOre = new BlockOre(Material.rock).setBlockName("cobaltOre").setBlockTextureName("crystalrevolution:cobaltOre");
		RegHelper.registerBlock(cobaltOre);
		rhodiumOre = new BlockOre(Material.rock).setBlockName("rhodiumOre").setBlockTextureName("crystalrevolution:rhodiumOre");
		RegHelper.registerBlock(rhodiumOre);
		palladiumOre = new BlockOre(Material.rock).setBlockName("palladiumOre").setBlockTextureName("crystalrevolution:palladiumOre");
		RegHelper.registerBlock(palladiumOre);
		osmiumOre = new BlockOre(Material.rock).setBlockName("osmiumOre").setBlockTextureName("crystalrevolution:osmiumOre");
		RegHelper.registerBlock(osmiumOre);
		iridiumOre = new BlockOre(Material.rock).setBlockName("iridiumOre").setBlockTextureName("crystalrevolution:iridiumOre");
		RegHelper.registerBlock(iridiumOre);
		platinOre = new BlockOre(Material.rock).setBlockName("platinOre").setBlockTextureName("crystalrevolution:platinOre");
		RegHelper.registerBlock(platinOre);
		mithrilOre = new BlockOre(Material.rock).setBlockName("mithrilOre").setBlockTextureName("crystalrevolution:mithrilOre");
		RegHelper.registerBlock(mithrilOre);
		
	}
}
