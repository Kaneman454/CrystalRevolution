package crystalrevolution.network.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
import crystalrevolution.utils.References;

@Sharable
public class PacketPipeline extends MessageToMessageCodec<FMLProxyPacket, AbstractPacket>{

	private EnumMap<Side, FMLEmbeddedChannel> channels;
	
	private LinkedList<Class<? extends AbstractPacket>> packets = new LinkedList<Class<? extends AbstractPacket>>();
	
	private boolean isPostInitialized = false;
	
	public boolean registerPacket(Class<? extends AbstractPacket> clazz){
		if(this.packets.size() > 256){
			System.err.println("Maximum amount of packets reached!");
			return false;
		}
		
		if(this.packets.contains(clazz)){
			System.err.println("This packet has already been registered!");
			return false;
		}
		
		if(this.isPostInitialized){
			System.err.println("Packet registered too late!");
			return false;
		}
		
		this.packets.add(clazz);
		return true;
	}
	
	public void init(){
		this.channels = NetworkRegistry.INSTANCE.newChannel(References.PACKET_CHANNEL, this);
		registerPackets();
	}
	
	public void postInitialize(){
		if(isPostInitialized)
			return;
		
		isPostInitialized = true;
		Collections.sort(this.packets, new Comparator<Class<? extends AbstractPacket>>() {
			@Override
			public int compare(Class<? extends AbstractPacket> o1, Class<? extends AbstractPacket> o2) {
				int com = String.CASE_INSENSITIVE_ORDER.compare(o1.getCanonicalName(), o2.getCanonicalName());
				
				if(com == 0){
					com = o1.getCanonicalName().compareTo(o2.getCanonicalName());
				}
				
				return com;
			}
		});
	}
	
	public void registerPackets(){
		registerPacket(OpenGUIPacket.class);
	}
	
	@Override
	protected void encode(ChannelHandlerContext ctx, AbstractPacket msg, List<Object> out) throws Exception {
		ByteBuf buffer = Unpooled.buffer();
		
		Class<? extends AbstractPacket> clazz = msg.getClass();
		
		if(!this.packets.contains(clazz)){
			throw new NullPointerException("This packet has never been registered!: " + clazz.getCanonicalName());
		}
		
		byte discriminator = (byte)this.packets.indexOf(clazz);
		buffer.writeByte(discriminator);
		msg.encodeInto(ctx, buffer);
		
		FMLProxyPacket ppacket = new FMLProxyPacket(buffer.copy(), ctx.channel().attr(NetworkRegistry.FML_CHANNEL).get());
		
		out.add(ppacket);
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, FMLProxyPacket msg, List<Object> out) throws Exception {
		ByteBuf payload = msg.payload();
		byte descriminator = payload.readByte();
		
		Class<? extends AbstractPacket> clazz = this.packets.get(descriminator);
		if(clazz == null){
			throw new NullPointerException("This packet has never been registered!: " + clazz.getCanonicalName());
		}
		
		AbstractPacket aPacket = clazz.newInstance();
		aPacket.decodeInto(ctx, payload.slice());
		
		EntityPlayer p;
		switch(FMLCommonHandler.instance().getEffectiveSide()) {
		case CLIENT:
			p = Minecraft.getMinecraft().thePlayer;
			aPacket.handleClientSide(p);
			break;
		case SERVER:
			INetHandler handler = ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
			p = ((NetHandlerPlayServer)handler).playerEntity;
			aPacket.handleServerSide(p);
			break;
		default:
		}
		
		out.add(aPacket);
	}
	
	public void sendToServer(AbstractPacket message){
		this.channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
		this.channels.get(Side.CLIENT).writeAndFlush(message);
	}

}
