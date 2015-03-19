package info.ccserver.homunculus.render;

import info.ccserver.homunculus.common.entity.EntityHomunculus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderAsEntity extends Render {

	RenderAsEntity(RenderManager renderManager) {
		super(renderManager);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@SideOnly(Side.CLIENT)
	public RenderAsEntity() {
		this(Minecraft.getMinecraft().getRenderManager());
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z,
			float p_76986_8_, float partialTicks) {
		this.doRender((EntityHomunculus) entity, x, y, z, p_76986_8_,
				partialTicks);
	}

	public void doRender(EntityHomunculus entity, double x, double y, double z,
			float p_76986_8_, float partialTicks) {
		// TODO たぶんここに色々書く

		entity.core().callRenderFunc(entity, x, y, z, p_76986_8_, partialTicks);
		super.doRender(entity, x, y, z, p_76986_8_, partialTicks);
	}
}
