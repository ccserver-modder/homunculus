package info.ccserver.homunculus.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemFlask extends Item {
	public ItemFlask(String unlocalizedName, CreativeTabs tab) {
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(tab);
	}
}
