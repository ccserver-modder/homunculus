package info.ccserver.homunculus;

import info.ccserver.homunculus.common.entity.EntityHomunculus;
import info.ccserver.homunculus.common.item.ItemFlask;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HomunculusData {

	public static CreativeTabs tab;

	public static Item itemFlask;
	public static final String nameFlask = "flask";

	public static final String nameHomunculus = "Homunculus";

	public static void registerPre() {
		tab = new TabHomunculus();

		/* アイテム登録 */
		itemFlask = new ItemFlask(nameFlask, tab);
		GameRegistry.registerItem(itemFlask, nameFlask);
		
		/* レシピ登録 */
		GameRegistry.addShapelessRecipe(new ItemStack(itemFlask, 1),
				new ItemStack(Items.egg,1),
				new ItemStack(Items.redstone, 1),
				new ItemStack(Items.potionitem, 1, 0),
				new ItemStack(Items.sugar,1)
				);

		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			ModelBakery.addVariantName(itemFlask,
					HomunculusMod.MODID.toLowerCase() + ":" + "flask"
				);
	        }

		/* エンティティ登録 */
		int trackingRange = 250;
		int updateFrequency = 1;
		boolean sendsVelocityUpdates = false;
		EntityRegistry.registerModEntity(EntityHomunculus.class,
				nameHomunculus, 0, HomunculusMod.instance, trackingRange,
				updateFrequency, sendsVelocityUpdates);
	}

	public static void register() {
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			registerItemJson(itemFlask, 0, "flask");
		}
	}

	public static void registerItemJson(Item item, int metadata, String name) {
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		ModelResourceLocation resource = new ModelResourceLocation(HomunculusMod.MODID.toLowerCase() + ":" + name, "inventory");
		mesher.register(item, metadata, resource);
	}

	public static class TabHomunculus extends CreativeTabs {
		public static final String label = "Homunculus";

		TabHomunculus() {
			super(label);
		}

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return itemFlask;
		}
	}

}