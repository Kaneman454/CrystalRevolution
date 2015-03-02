package crystalrevolution.gameobjs.metals;

import crystalrevolution.gameobjs.crystalTab;
import crystalrevolution.libs.LibMisc;
import net.minecraft.item.Item;

public class ingotPalladium extends Item {

	public ingotPalladium() {
		super();
		setCreativeTab(crystalTab.crystalCreativeTab);
		setUnlocalizedName("ingotPalladium");
		setTextureName(LibMisc.MOD_ID + ":" + getUnlocalizedName().substring(5));
	}

}
