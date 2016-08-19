package com.anzanama.everythinginbetween.Common.Block;

import com.anzanama.everythinginbetween.Common.tile.TilePlayerAugmentor;
import com.anzanama.everythinginbetween.EverythingInBetween;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew Graber on 8/16/2016.
 */
public class BlockPlayerAugmentor extends BlockTileEIB {

    public BlockPlayerAugmentor(){
        super("player_augmentor", Material.ROCK, 50, 50);
        this.setCreativeTab(EverythingInBetween.tab);
        GameRegistry.register(this);
    }

    public TileEntity createNewTileEntity(World world, int meta){
        return new TilePlayerAugmentor();
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn){
        playerIn.addChatMessage(new TextComponentString("Augment Type: " + ((TilePlayerAugmentor)worldIn.getTileEntity(pos)).getAugmentType()));
    }


}
