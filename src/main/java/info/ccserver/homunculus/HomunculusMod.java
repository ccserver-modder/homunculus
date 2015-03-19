package info.ccserver.homunculus;

import info.ccserver.homunculus.network.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

/**
 * @author quartz
 */

@Mod(modid = HomunculusMod.MODID, version = "0.0.0", name = "Homunculus Mod")
public class HomunculusMod {
	public static final String MODID = "homumod";

	@Instance(MODID)
	public static HomunculusMod instance;

	@SidedProxy(modId = HomunculusMod.MODID, clientSide = "info.ccserver.homunculus.network.ProxyClient", serverSide = "info.ccserver.homunculus.network.ProxyServer")
	public static IProxy proxy;

	public static final SimpleNetworkWrapper packetHandler = NetworkRegistry.INSTANCE
			.newSimpleChannel(MODID);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		HomunculusData.registerPre();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		HomunculusData.register();
		proxy.registerTileEntities();
		proxy.registerEntities();
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}
}
