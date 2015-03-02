package crystalrevolution.handlers;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import crystalrevolution.Main;
import crystalrevolution.libs.LibMisc;
import crystalrevolution.network.packet.OpenGUIPacket;
import crystalrevolution.utils.References;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;

public class KeyHandler {

	public static final int BACKPACK_KEY = 0;
	
	private static final String[] keyDesc = {"key.crystalrevolution.backpack.desc"};
	private static final int[] keyValues = {Keyboard.KEY_B};
	private final KeyBinding[] keys;
		
	public KeyHandler(){
		keys = new KeyBinding[keyValues.length];
		for(int i = 0; i < keyValues.length; i++){
			keys[i] = new KeyBinding(keyDesc[i], keyValues[i], "key.crystalrevolution.category");
			ClientRegistry.registerKeyBinding(keys[i]);
		}
	}
	@SubscribeEvent
	public void onKeyPressed(InputEvent.KeyInputEvent event){
		if(!FMLClientHandler.instance().isGUIOpen(GuiChat.class)){
			int key = Keyboard.getEventKey();
			boolean isPressed = Keyboard.getEventKeyState();
			
			//Backpack
			if(isPressed && key == keyValues[BACKPACK_KEY]){
				// Send packet to open gui
				LibMisc.packetPipeLine.sendToServer(new OpenGUIPacket(References.GUI_BACKPACK));;
			}
		}
	}
}
