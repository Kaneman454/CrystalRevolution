package crystalrevolution.gameobjs.metals;

import crystalrevolution.gameobjs.crystalTab;
import crystalrevolution.libs.LibMisc;
import net.minecraft.item.Item;

public class ingotRhodium extends Item {

	public ingotRhodium() {
		super();
		setCreativeTab(crystalTab.crystalCreativeTab);
		setUnlocalizedName("ingotRhodium");
		setTextureName(LibMisc.MOD_ID + ":" + getUnlocalizedName().substring(5));
	}

}
