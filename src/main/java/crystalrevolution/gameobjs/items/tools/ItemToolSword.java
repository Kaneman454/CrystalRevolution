package crystalrevolution.gameobjs.items.tools;

import crystalrevolution.gameobjs.crystalTab;
import net.minecraft.item.ItemSword;

public class ItemToolSword extends ItemSword{

	public ItemToolSword(ToolMaterial mat) {
		super(mat);
		setCreativeTab(crystalTab.crystalCreativeTab);
	}

}
