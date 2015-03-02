package crystalrevolution.handlers;

import java.util.Calendar;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crystalrevolution.Main;

public class EEventHandler {

	boolean checkedDate;

	
	@SubscribeEvent
	public void onWorldJoin(PlayerEvent.PlayerLoggedInEvent e){
		AchievementHandler.triggerAchievement(e.player, "crystalrevolution.early_stoneage");
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void clientWorldTick(TickEvent.ClientTickEvent e){
		
		if(e.side == Side.SERVER) return;
		Minecraft mc = FMLClientHandler.instance().getClient();
		World w = mc.theWorld;
		
		if((mc.theWorld != null) && (!this.checkedDate)){
			this.checkedDate = true;
			Calendar c = mc.theWorld.getCurrentDate();
			if((c.get(2) + 1 == 10) && (c.get(5) == 31)){
				Main.isHalloween = true;
			}
			else if(c.get(2) == 12 && (c.get(5) == 24)){
				Main.isChristmas = true;
			}
		}
	}
}
