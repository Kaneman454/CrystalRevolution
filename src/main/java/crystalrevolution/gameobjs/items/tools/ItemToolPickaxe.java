package crystalrevolution.gameobjs.items.tools;

import crystalrevolution.gameobjs.crystalTab;
import net.minecraft.item.ItemPickaxe;

public class ItemToolPickaxe extends ItemPickaxe{

	public ItemToolPickaxe(ToolMaterial mat) {
		super(mat);
		setCreativeTab(crystalTab.crystalCreativeTab);
	}

}
