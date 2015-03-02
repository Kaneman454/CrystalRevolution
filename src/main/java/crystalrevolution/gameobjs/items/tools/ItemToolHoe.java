package crystalrevolution.gameobjs.items.tools;

import crystalrevolution.gameobjs.crystalTab;
import net.minecraft.item.ItemHoe;

public class ItemToolHoe extends ItemHoe{

	public ItemToolHoe(ToolMaterial mat) {
		super(mat);
		setCreativeTab(crystalTab.crystalCreativeTab);
	}

}
