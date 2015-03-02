package crystalrevolution.network.packet;

import cpw.mods.fml.common.network.FMLNetworkEvent;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import crystalrevolution.Main;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

public class OpenGUIPacket extends AbstractPacket{

	private byte ID;
	
	public OpenGUIPacket(){}
	
	public OpenGUIPacket(byte ID) {
		this.ID = ID;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeByte(ID);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		ID = buffer.readByte();
	}

	@Override
	public void handleClientSide(EntityPlayer p) {
		
	}

	@Override
	public void handleServerSide(EntityPlayer p) {
		System.out.println("WORKS");
		FMLNetworkHandler.openGui(p, Main.instance, ID, p.worldObj, (int)p.posX, (int)p.posY, (int)p.posZ);
	}

}
