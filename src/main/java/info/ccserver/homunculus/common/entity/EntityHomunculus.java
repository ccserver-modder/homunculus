package info.ccserver.homunculus.common.entity;

import info.ccserver.homunculus.core.HomunculusCore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityHomunculus extends Entity implements IHomunculus {

	private HomunculusCore homunculusCore;

	public void init(){
		
	};
	
	public EntityHomunculus(World worldIn) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(worldIn);
		// TODO コア管理
		homunculusCore = new HomunculusCore();
	}

	@Override
	protected void entityInit() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tagCompund) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompound) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public boolean interactFirst(EntityPlayer playerIn) {
		// TODO 自動生成されたメソッド・スタブ

		return false;
	}

	@Override
	public HomunculusCore core() {
		return homunculusCore;
	}
}
