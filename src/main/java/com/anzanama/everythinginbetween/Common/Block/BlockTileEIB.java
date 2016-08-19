package com.anzanama.everythinginbetween.Common.Block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Andrew Graber on 8/16/2016.
 */
public class BlockTileEIB extends BlockEIB implements ITileEntityProvider{

    public BlockTileEIB(String name, Material material, int hardness, int resistance){
        super(name, material, hardness, resistance);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta){
        return null;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
        super.breakBlock(world, pos, state);
        world.removeTileEntity(pos);
    }

    @Override
    public boolean eventReceived(IBlockState state, World world, BlockPos pos, int id, int param){
        super.eventReceived(state, world, pos, id, param);
        TileEntity tileentity = world.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(id, param);
    }
}
