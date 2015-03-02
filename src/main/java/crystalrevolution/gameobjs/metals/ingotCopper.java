package crystalrevolution.gameobjs.metals;

import crystalrevolution.gameobjs.crystalTab;
import crystalrevolution.libs.LibMisc;
import net.minecraft.item.Item;

public class ingotCopper extends Item {

	public ingotCopper() {
		super();
		setCreativeTab(crystalTab.crystalCreativeTab);
		setUnlocalizedName("ingotCopper");
		setTextureName(LibMisc.MOD_ID + ":" + getUnlocalizedName().substring(5));
	}

	
	
}
