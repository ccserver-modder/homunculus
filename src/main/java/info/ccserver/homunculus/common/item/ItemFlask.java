package info.ccserver.homunculus.common.item;
import info.ccserver.homunculus.common.entity.EntityHomunculus;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemFlask extends Item {
	public ItemFlask(String unlocalizedName, CreativeTabs tab) {
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(tab);
		this.setMaxStackSize(1);
		

	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

        if (movingobjectposition == null)
        {
            return itemStack;
        } else {
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                BlockPos blockpos = movingobjectposition.getBlockPos();

                if (!world.isBlockModifiable(player, blockpos)){
                    return itemStack;
                }

                if (!player.canPlayerEdit(blockpos.offset(movingobjectposition.sideHit), movingobjectposition.sideHit, itemStack))
                {
                    return itemStack;
                }

                BlockPos blockpos1 = blockpos.up();
                IBlockState iblockstate = world.getBlockState(blockpos);

                
                //睡蓮の葉の設置処理を改造した召喚可能判定。　四方がガラスに囲まれ、下にガラスか石、あるいは金属ブロックがあり上が空気ブロックの水源にフラスコを右クリックすることで召喚する（ただし判定アウトでもフラスコは消滅する）
                //ゴミが色々と残ってるかも。

                if (iblockstate.getBlock().getMaterial() == Material.water && ((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0 && world.isAirBlock(blockpos1))
                {

                    net.minecraftforge.common.util.BlockSnapshot blocksnapshot = net.minecraftforge.common.util.BlockSnapshot.getBlockSnapshot(world, blockpos1);
                    
                    //int watX = blockpos.getX();
                    //int watY = blockpos.getY();
                    //int watZ = blockpos.getZ();
                    
                    BlockPos blockpos2 = blockpos.east();
                    BlockPos blockpos3 = blockpos.north();
                    BlockPos blockpos4 = blockpos.south();
                    BlockPos blockpos5 = blockpos.west();
                    BlockPos blockpos6 = blockpos.down();
                    
                    if ( (world.getBlockState(blockpos2).getBlock().getMaterial() == Material.glass)&&(world.getBlockState(blockpos3).getBlock().getMaterial() == Material.glass)&&(world.getBlockState(blockpos4).getBlock().getMaterial() == Material.glass)&&(world.getBlockState(blockpos5).getBlock().getMaterial() == Material.glass)  )
                    	{
                    	//四方がガラスに囲まれている
                    	if ( (world.getBlockState(blockpos6).getBlock().getMaterial() == Material.rock)||(world.getBlockState(blockpos6).getBlock().getMaterial() == Material.iron)||(world.getBlockState(blockpos6).getBlock().getMaterial() == Material.glass) )
                    		{
                    		//底が石か鉄かガラスで塞がれている
                    		
                    		System.out.println("召喚可能と判断");

                    		EntityHomunculus theEntity = new EntityHomunculus(world);
                            theEntity.rotationYaw = (float)(((MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) - 1) * 90);
                            theEntity.setPosition(blockpos.getX()+0.5F, blockpos.getY()+0.5F, blockpos.getZ()+0.5F);
                            world.spawnEntityInWorld(theEntity);
                    		
                    		}
                    	
                    	}
                    
                    
                    
                    
                    
                    
                    
                    //world.setBlockState(blockpos1, Blocks.waterlily.getDefaultState());
                   // if (net.minecraftforge.event.ForgeEventFactory.onPlayerBlockPlace(player, blocksnapshot, net.minecraft.util.EnumFacing.UP).isCanceled())
                   // {
                   //     blocksnapshot.restore(true, false);
                   //     return itemStack;
                   // }

                    if (!player.capabilities.isCreativeMode)
                    {
                        --itemStack.stackSize;
                    }

                    player.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
                }
            }

            return itemStack;//判定アウトでも消費される
        }
	}
}

