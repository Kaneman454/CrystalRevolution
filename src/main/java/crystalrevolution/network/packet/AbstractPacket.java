package crystalrevolution.network.packet;

import net.minecraft.entity.player.EntityPlayer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public abstract class AbstractPacket {

	public abstract void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer);
	
	public abstract void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer);

	public abstract void handleClientSide(EntityPlayer p);
	
	public abstract void handleServerSide(EntityPlayer p);
}
