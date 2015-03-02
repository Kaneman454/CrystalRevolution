package crystalrevolution.gameobjs.metals;

import crystalrevolution.gameobjs.crystalTab;
import crystalrevolution.libs.LibMisc;
import net.minecraft.item.Item;

public class ingotZinc extends Item {

	public ingotZinc() {
		super();
		setCreativeTab(crystalTab.crystalCreativeTab);
		setUnlocalizedName("ingotZinc");
		setTextureName(LibMisc.MOD_ID + ":" + getUnlocalizedName().substring(5));
	}

}
