package crystalrevolution.libs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import crystalrevolution.network.packet.PacketPipeline;

public class LibMisc {

	// Mod Constants
	public static final String MOD_ID = "crystalrevolution";
	public static final String MOD_NAME = "Crystal Revolution";
	public static final String BUILD = "GRADLE:BUILD";
	public static final String VERSION = "GRADLE:VERSION-" + BUILD;
	public final static String MOD_DEPENDENCIES = 
			"required-after:Forge@[" // require forge.
			+ net.minecraftforge.common.ForgeVersion.majorVersion + '.' // majorVersion
			+ net.minecraftforge.common.ForgeVersion.minorVersion + '.' // minorVersion
			+ net.minecraftforge.common.ForgeVersion.revisionVersion + '.' // revisionVersion
			+ net.minecraftforge.common.ForgeVersion.buildVersion + ",)";

	// Network Contants
	public static final String NETWORK_CHANNEL = MOD_ID;

	// Proxy Constants
	public static final String PROXY_SERVER = "crystalrevolution.proxies.ServerProxy";
	public static final String PROXY_CLIENT = "crystalrevolution.proxies.ClientProxy";
	public static final Logger logger = LogManager.getLogger("Crystal Revolution");
	
	public static final PacketPipeline packetPipeLine = new PacketPipeline();
	
}
