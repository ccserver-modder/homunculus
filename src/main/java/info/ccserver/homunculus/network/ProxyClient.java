package info.ccserver.homunculus.network;

import info.ccserver.homunculus.common.entity.EntityHomunculus;
import info.ccserver.homunculus.render.RenderAsEntity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;


public class ProxyClient implements IProxy {

	@Override
	public void registerTileEntities() {
	}

	@Override
	public void registerEntities() {
		System.out.println("registerEntityes");
		RenderingRegistry.registerEntityRenderingHandler(
				EntityHomunculus.class, new RenderAsEntity());

	}

}
