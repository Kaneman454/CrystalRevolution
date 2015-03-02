package crystalrevolution.gameobjs.metals;

import crystalrevolution.gameobjs.crystalTab;
import crystalrevolution.libs.LibMisc;
import net.minecraft.item.Item;

public class ingotBrass extends Item {

	public ingotBrass() {
		super();
		setCreativeTab(crystalTab.crystalCreativeTab);
		setUnlocalizedName("ingotBrass");
		setTextureName(LibMisc.MOD_ID + ":" + getUnlocalizedName().substring(5));
	}

}
