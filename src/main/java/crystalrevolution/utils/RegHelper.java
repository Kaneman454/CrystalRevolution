package crystalrevolution.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegHelper {

	public static void registerBlock(Block block)
	  {
	    GameRegistry.registerBlock(block, "tile." + block.getUnlocalizedName().substring(5));
	  }
	  
	  public static void registerBlock(Block block, String name)
	  {
	    GameRegistry.registerBlock(block, name);
	  }
	  
	  public static void registerBlock(Block block, Class<? extends ItemBlock> itemclass)
	  {
	    GameRegistry.registerBlock(block, itemclass, "tile." + block.getUnlocalizedName().substring(5));
	  }
	  
	  public static void registerItem(Item item)
	  {
	    GameRegistry.registerItem(item, "item." + item.getUnlocalizedName().substring(5));
	  }
	  
	  public static void registerFluid(FluidStack stack, ItemStack itemFull, ItemStack itemEmpty)
	  {
	    FluidContainerRegistry.registerFluidContainer(stack, itemFull, itemEmpty);
	  }
	  
	  public static void registerWorldGen(IWorldGenerator worldGenerator)
	  {
	    GameRegistry.registerWorldGenerator(worldGenerator, 0);
	  }
	
}
