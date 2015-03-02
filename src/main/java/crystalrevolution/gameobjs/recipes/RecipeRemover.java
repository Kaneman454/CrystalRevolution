package crystalrevolution.gameobjs.recipes;

import java.util.List;

import crystalrevolution.Main;
import crystalrevolution.config.CrystalConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class RecipeRemover {

		public static void RecipeRemove(){
	    	
	    	for(int i = 0; i < CrystalConfig.recipeList.length; i++)
	        {
	        	  removeRecipes(CrystalConfig.recipeList[i]);
	        }
	    	
	    	
		}
	
	 	@SuppressWarnings("unchecked")
	    private static void removeRecipes(String toDelete)
	    {    
	    	ItemStack resultItem = new ItemStack((Item)Item.itemRegistry.getObject(toDelete));
	    	
			List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
	       
			for (int i = 0; i < recipes.size(); i++)
	        {
	            IRecipe tmpRecipe = recipes.get(i);
	            ItemStack recipeResult = tmpRecipe.getRecipeOutput();
	            if (resultItem != null && recipeResult != null) resultItem.stackSize = recipeResult.stackSize;
	            
	            if (ItemStack.areItemStacksEqual(resultItem, recipeResult))
	            {
	                recipes.remove(i--);
	            }
	        }
	    }
}
