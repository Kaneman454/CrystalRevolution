package crystalrevolution.gameobjs.recipes;

import java.util.List;

import crystalrevolution.gameobjs.ModBlocks;
import crystalrevolution.gameobjs.ModItems;
import net.minecraft.item.ItemStack;
import appeng.api.features.IGrinderEntry;
import appeng.api.features.IGrinderRegistry;

public class AEGrinderRecipes implements IGrinderRegistry{
	
	@Override
	public List<IGrinderEntry> getRecipes() {
		return null;
	}

	@Override
	public void addRecipe(ItemStack in, ItemStack out, int turns) {
		this.addRecipe(new ItemStack(ModBlocks.copperOre), new ItemStack(ModItems.ingots, 2, 0), 8);
	}

	@Override
	public void addRecipe(ItemStack in, ItemStack out, ItemStack optional, float chance, int turns) {
		
	}

	@Override
	public void addRecipe(ItemStack in, ItemStack out, ItemStack optional, float chance, ItemStack optional2, float chance2, int turns) {
		
	}

	@Override
	public IGrinderEntry getRecipeForInput(ItemStack input) {
		return null;
	}

}
