package crystalrevolution.gameobjs.items.tools;

import crystalrevolution.gameobjs.crystalTab;
import net.minecraft.item.ItemSpade;

public class ItemToolShovel extends ItemSpade{

	public ItemToolShovel(ToolMaterial mat) {
		super(mat);
		setCreativeTab(crystalTab.crystalCreativeTab);
	}

}
