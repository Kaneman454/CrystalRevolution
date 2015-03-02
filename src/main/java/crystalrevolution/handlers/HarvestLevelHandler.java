package crystalrevolution.handlers;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.oredict.OreDictionary;
import crystalrevolution.gameobjs.ModBlocks;
import crystalrevolution.utils.ModHandler;

import java.lang.reflect.Field;
import java.util.LinkedList;

public class HarvestLevelHandler {

	public static final int _0_wood = 0;
	public static final int _1_flint = 1;
	public static final int _2_stone = 2;
	public static final int _3_copper = 3;
	public static final int _4_bronze = 4;
	public static final int _5_iron = 5;
	public static final int _6_redstone = 6;
	public static final int _7_diamond = 7;
	public static final int _8_obsidian = 8;
	public static final int _9_cobalt = 9;
	public static final int _10_rhodium = 10;
	public static final int _11_palladium = 11;
	public static final int _12_osmium = 12;
	public static final int _13_iridium = 13;
	public static final int _14_platin = 14;
	public static final int _15_mithril = 15;
		
	public HarvestLevelHandler() {}
	
	public static void changeHarvestLevel(){
		HandleVanillaHarvestlvl();
	}

	public static void HandleVanillaHarvestlvl(){
		new ForgeHooks();
		Blocks.coal_ore.setHarvestLevel("pickaxe", _3_copper);
		Blocks.iron_ore.setHarvestLevel("pickaxe", _4_bronze);
		Blocks.redstone_ore.setHarvestLevel("pickaxe", _5_iron);
		Blocks.gold_ore.setHarvestLevel("pickaxe", _6_redstone);
		Blocks.diamond_ore.setHarvestLevel("pickaxe", _6_redstone);
		Blocks.emerald_ore.setHarvestLevel("pickaxe", _6_redstone);
		Blocks.obsidian.setHarvestLevel("pickaxe", _7_diamond);

		Items.wooden_pickaxe.setHarvestLevel("pickaxe", _0_wood);
		Items.stone_pickaxe.setHarvestLevel("pickaxe", _2_stone);
		Items.iron_pickaxe.setHarvestLevel("pickaxe", _6_redstone);
		Items.golden_pickaxe.setHarvestLevel("pickaxe", _1_flint);
		Items.diamond_pickaxe.setHarvestLevel("pickaxe", _7_diamond);
	}
	       
}
