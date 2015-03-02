package crystalrevolution.handlers;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class HarvestEventHandler {

	public static ItemStack heldItem;
	public static final Block AE2quartzOre = GameRegistry.findBlock("appliedenergistcs2", "oreCertusQuartz");
	
	@SubscribeEvent
	public void onHarvestCheck(PlayerEvent.HarvestCheck check){
		heldItem = check.entityPlayer.inventory.getCurrentItem();
		if(check.block ==  AE2quartzOre){
			if(heldItem != null && heldItem.getItem() == Items.diamond_pickaxe){
				check.success = true;
			}
		}
	}
}
