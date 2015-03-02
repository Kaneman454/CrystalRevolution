package crystalrevolution.gameobjs.recipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import appeng.api.features.IGrinderEntry;
import appeng.api.features.IGrinderRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import crystalrevolution.config.CrystalConfig;
import crystalrevolution.gameobjs.ModBlocks;
import crystalrevolution.gameobjs.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipeManager{
	
	public static CraftingManager craftManager = CraftingManager.getInstance();
	public static List<IRecipe> recipes = craftManager.getRecipeList();
	public static Iterator<IRecipe> remover = recipes.iterator();
	
	public static void manageRecipes(){
		
		addCrafting();
		addSmelting();
		addVanillaRecipes();
	}
		
	private static void addSmelting(){
			//--Leather Armor
			GameRegistry.addSmelting(Items.leather_helmet, new ItemStack(Items.leather, 5), 0.0F);
			GameRegistry.addSmelting(Items.leather_chestplate, new ItemStack(Items.leather, 8), 0.0F);
			GameRegistry.addSmelting(Items.leather_leggings, new ItemStack(Items.leather, 7), 0.0F);
			GameRegistry.addSmelting(Items.leather_boots, new ItemStack(Items.leather, 4), 0.0F);
			//--Iron Armor
			GameRegistry.addSmelting(Items.iron_helmet, new ItemStack(Items.iron_ingot, 5), 0.0F);
			GameRegistry.addSmelting(Items.iron_chestplate, new ItemStack(Items.iron_ingot, 8), 0.0F);
			GameRegistry.addSmelting(Items.iron_leggings, new ItemStack(Items.iron_ingot, 7), 0.0F);
			GameRegistry.addSmelting(Items.iron_boots, new ItemStack(Items.iron_ingot, 4), 0.0F);
			//--Gold Armor
			GameRegistry.addSmelting(Items.golden_helmet, new ItemStack(Items.gold_ingot, 5), 0.0F);
			GameRegistry.addSmelting(Items.golden_chestplate, new ItemStack(Items.gold_ingot, 8), 0.0F);
			GameRegistry.addSmelting(Items.golden_leggings, new ItemStack(Items.gold_ingot, 7), 0.0F);
			GameRegistry.addSmelting(Items.golden_boots, new ItemStack(Items.gold_ingot, 4), 0.0F);
			//--Diamond Armor
			GameRegistry.addSmelting(Items.diamond_helmet, new ItemStack(Items.diamond, 5), 0.0F);
			GameRegistry.addSmelting(Items.diamond_chestplate, new ItemStack(Items.diamond, 8), 0.0F);
			GameRegistry.addSmelting(Items.diamond_leggings, new ItemStack(Items.diamond, 7), 0.0F);
			GameRegistry.addSmelting(Items.diamond_boots, new ItemStack(Items.diamond, 4), 0.0F);
			
			GameRegistry.addSmelting(Items.iron_horse_armor, new ItemStack(Items.iron_ingot, 4), 0.0F);
			GameRegistry.addSmelting(Items.golden_horse_armor, new ItemStack(Items.gold_ingot, 4), 0.0F);
			GameRegistry.addSmelting(Items.diamond_horse_armor, new ItemStack(Items.diamond, 4), 0.0F);
	}
		
	private static void addCrafting(){
		//Armor
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.Backpack), new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), Items.leather}));
		
		//Machines
		recipes.add(new ShapedOreRecipe(new ItemStack(ModBlocks.smelteryIdle), new Object[]{"GLG", "FGF", "GLG", Character.valueOf('G'), new ItemStack(ModItems.gears, 1, 2), Character.valueOf('L'), Items.lava_bucket, Character.valueOf('F'), Blocks.furnace}));
	
		//Materials
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gears, 4, 0), new Object[]{" X ", "X X", " X ", Character.valueOf('X'), Items.stick}));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gears, 4, 1), new Object[]{" X ", "XSX", " X ", Character.valueOf('X'), Items.flint, Character.valueOf('S'), new ItemStack(ModItems.gears, 1, 0)}));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gears, 4, 2), new Object[]{" X ", "XSX", " X ", Character.valueOf('X'), Blocks.cobblestone, Character.valueOf('S'), new ItemStack(ModItems.gears, 1, 1)}));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gears, 4, 3), new Object[]{" X ", "XSX", " X ", Character.valueOf('X'), new ItemStack(ModItems.ingotCopper), Character.valueOf('S'), new ItemStack(ModItems.gears, 1, 2)}));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gears, 4, 4), new Object[]{" X ", "XSX", " X ", Character.valueOf('X'), new ItemStack(ModItems.ingotTin), Character.valueOf('S'), new ItemStack(ModItems.gears, 1, 3)}));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gears, 4, 5), new Object[]{" X ", "XSX", " X ", Character.valueOf('X'), new ItemStack(ModItems.ingotZinc), Character.valueOf('S'), new ItemStack(ModItems.gears, 1, 4)}));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gears, 4, 6), new Object[]{" X ", "XSX", " X ", Character.valueOf('X'), new ItemStack(ModItems.ingotBronze), Character.valueOf('S'), new ItemStack(ModItems.gears, 1, 5)}));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gears, 4, 7), new Object[]{" X ", "XSX", " X ", Character.valueOf('X'), new ItemStack(ModItems.ingotBrass), Character.valueOf('S'), new ItemStack(ModItems.gears, 1, 6)}));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gears, 4, 8), new Object[]{" X ", "XSX", " X ", Character.valueOf('X'), new ItemStack(ModItems.ingotCobalt), Character.valueOf('S'), new ItemStack(ModItems.gears, 1, 7)}));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gears, 4, 9), new Object[]{" X ", "XSX", " X ", Character.valueOf('X'), new ItemStack(ModItems.ingotRhodium), Character.valueOf('S'), new ItemStack(ModItems.gears, 1, 8)}));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gears, 4, 10), new Object[]{" X ", "XSX", " X ", Character.valueOf('X'), new ItemStack(ModItems.ingotPalladium), Character.valueOf('S'), new ItemStack(ModItems.gears, 1, 9)}));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gears, 4, 11), new Object[]{" X ", "XSX", " X ", Character.valueOf('X'), new ItemStack(ModItems.ingotOsmium), Character.valueOf('S'), new ItemStack(ModItems.gears, 1, 10)}));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gears, 4, 12), new Object[]{" X ", "XSX", " X ", Character.valueOf('X'), new ItemStack(ModItems.ingotIridium), Character.valueOf('S'), new ItemStack(ModItems.gears, 1, 11)}));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gears, 4, 13), new Object[]{" X ", "XSX", " X ", Character.valueOf('X'), new ItemStack(ModItems.ingotPlatin), Character.valueOf('S'), new ItemStack(ModItems.gears, 1, 12)}));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gears, 4, 14), new Object[]{" X ", "XSX", " X ", Character.valueOf('X'), new ItemStack(ModItems.ingotMithril), Character.valueOf('S'), new ItemStack(ModItems.gears, 1, 13)}));
		//Blocks
		
	}
	
	private static void addVanillaRecipes(){
		recipes.add(new ShapedOreRecipe(new ItemStack(Items.clay_ball, 32), new Object[]{"XXX", "XSX", "XXX", Character.valueOf('X'), new ItemStack(Blocks.clay), Character.valueOf('S'), new ItemStack(Items.water_bucket)}));
	}

}
	
