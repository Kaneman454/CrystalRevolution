package crystalrevolution.gameobjs;

import net.minecraft.item.Item;
import crystalrevolution.gameobjs.items.baubles.*;
import crystalrevolution.utils.RegHelper;

public class BaubleRegistration {

	public static Item ringRevealing;
	
	public static void registerBaubles(){
		ringRevealing = new ringRevealing();
		RegHelper.registerItem(ringRevealing);
	}
}
