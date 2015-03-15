package info.ccserver.homunculus;

import info.ccserver.homunculus.common.entity.EntityHomunculus;
import info.ccserver.homunculus.common.entity.RenderHomunculus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * @author quartz
 */

@Mod(modid = HomunculusMod.MODID, version = "0.0.0", name = "Homunculus Mod")
public class HomunculusMod {
	public static final String MODID = "homumod";
	public static final String ENTITY_NAME = "Homunculus";

	@Instance(MODID)
	public static HomunculusMod instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		HomunculusData.registerPre();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		HomunculusData.register();

		int trackingRange = 250;
		int updateFrequency = 1;
		boolean sendsVelocityUpdates = false;
		EntityRegistry.registerModEntity(EntityHomunculus.class,
				HomunculusMod.ENTITY_NAME, 0, this, trackingRange,
				updateFrequency, sendsVelocityUpdates);
		if (event.getSide() == Side.CLIENT) {
			RenderingRegistry.registerEntityRenderingHandler(
					EntityHomunculus.class, new RenderHomunculus());
		}
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}
}
