package info.ccserver.homunculus.common.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderHomunculus extends Render {

	RenderHomunculus(RenderManager renderManager) {
		super(renderManager);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@SideOnly(Side.CLIENT)
	public RenderHomunculus() {
		this(Minecraft.getMinecraft().getRenderManager());
		// this.shadowSize = 0.15F;
		// this.shadowOpaque = 0.75F;
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

		super.doRender(entity, x, y, z, p_76986_8_, partialTicks);
	}
}
