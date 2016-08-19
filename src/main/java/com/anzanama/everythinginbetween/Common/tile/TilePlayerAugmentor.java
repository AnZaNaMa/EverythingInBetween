package com.anzanama.everythinginbetween.Common.tile;


import com.anzanama.everythinginbetween.Common.Block.BlockBubbledStone;
import com.anzanama.everythinginbetween.Common.Block.BlocksEIB;
import com.anzanama.everythinginbetween.Common.Block.EnumColor;
import com.anzanama.everythinginbetween.Common.Enum.EnumPlayerAugment;
import com.anzanama.everythinginbetween.Common.Multiblock.MultiblockMaps;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

/**
 * Created by Andrew Graber on 8/16/2016.
 */
public class TilePlayerAugmentor extends TileEntity implements ITickable {
    String uuid;
    EnumPlayerAugment augment;

    public TilePlayerAugmentor(){
        this.uuid = "";
        this.augment = EnumPlayerAugment.NONE;
    }

    @Override
    public void update(){
        if(this.augment.equals(EnumPlayerAugment.NONE)){
            this.augment = findAugmentType();
        } else if(this.augment.equals(EnumPlayerAugment.SPEED)){
            if(!this.checkSpeedAugment()){
                this.augment = EnumPlayerAugment.NONE;
            }
        }
    }

    private EnumPlayerAugment findAugmentType(){
        BlockPos position = new BlockPos(pos.getX(), pos.getY()+2, pos.getZ());
        if(worldObj.getBlockState(position).getBlock().equals(BlocksEIB.bubbled_stone)){
            if(worldObj.getBlockState(position).equals(BlocksEIB.bubbled_stone.getDefaultState().withProperty(BlockBubbledStone.COLOR, EnumColor.GREEN))){
                return EnumPlayerAugment.SPEED;
            }
            else if(worldObj.getBlockState(position).equals(BlocksEIB.bubbled_stone.getDefaultState().withProperty(BlockBubbledStone.COLOR, EnumColor.ORANGE))){
                return EnumPlayerAugment.OUTPUT;
            }
            else if(worldObj.getBlockState(position).equals(BlocksEIB.bubbled_stone.getDefaultState().withProperty(BlockBubbledStone.COLOR, EnumColor.TEAL))){
                return EnumPlayerAugment.DURATION;
            }
            else{
                return EnumPlayerAugment.NONE;
            }
        }
        else{
            return EnumPlayerAugment.NONE;
        }
    }

    private boolean checkSpeedAugment(){
        boolean stillTrue = true;
        for(int i = 0; i < MultiblockMaps.PlayerAugmentSpeed.length; i++){
            for(int j = 0; j < MultiblockMaps.PlayerAugmentSpeed[i].length; i++){
                for(int k = 0; k < MultiblockMaps.PlayerAugmentSpeed[i][j].length; i++){
                    if(!(worldObj.getBlockState(new BlockPos(pos.getX()-2+k, pos.getY()+i, pos.getZ()-2+j)).equals(MultiblockMaps.PlayerAugmentSpeed[i][j][k]))){
                        stillTrue = false;
                        break;
                    }
                }
            }
        }
        return stillTrue;
    }

    public String getAugmentType(){
        return this.augment.getName();
    }
}
