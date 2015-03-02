package crystalrevolution.gameobjs.items.tools;

import crystalrevolution.gameobjs.crystalTab;
import net.minecraft.item.ItemAxe;

public class ItemToolAxe extends ItemAxe{

	public ItemToolAxe(ToolMaterial mat) {
		super(mat);
		setCreativeTab(crystalTab.crystalCreativeTab);
	}

}
