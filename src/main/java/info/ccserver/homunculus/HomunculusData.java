package info.ccserver.homunculus;

import info.ccserver.homunculus.common.item.ItemFlask;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HomunculusData {

	public static CreativeTabs tab;

	public static Item itemFlask;
	public static final String nameFlask = "flask";

	public static void registerPre() {
		tab = new TabHomunculus();

		itemFlask = new ItemFlask(nameFlask, tab);
		GameRegistry.registerItem(itemFlask, nameFlask);
		
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
	 
	        	ModelBakery.addVariantName(itemFlask,
						HomunculusMod.MODID.toLowerCase() + ":" + "flask"
				);
	 
	        }
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