package crystalrevolution.handlers.helpers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import crystalrevolution.gameobjs.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SmelteryRecipeHandler {

	public SmelteryRecipeHandler()
	{
		
	}
	
	public static ItemStack getSmeltingResult(Item item, Item item2)
	{
		return getOutput(item, item2);
	}

	public static ItemStack getOutput(Item item, Item item2)
	{
		if(item == ModItems.ingotCopper && item2 == ModItems.ingotTin || item == ModItems.ingotTin && item2 == ModItems.ingotCopper){
			return new ItemStack(ModItems.ingotBronze, 2);
		}
		
		if(item == ModItems.ingotCopper && item2 == ModItems.ingotZinc || item == ModItems.ingotZinc && item2 == ModItems.ingotCopper){
			return new ItemStack(ModItems.ingotBrass, 2);
		}
		
		return null;
	}
	
}
