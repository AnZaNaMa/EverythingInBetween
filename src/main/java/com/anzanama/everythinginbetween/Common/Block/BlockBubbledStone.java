package com.anzanama.everythinginbetween.Common.Block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by Andrew Graber on 8/12/2016.
 */
public class BlockBubbledStone extends BlockEIB {

    public static final PropertyEnum<EnumColor> COLOR = PropertyEnum.<EnumColor>create("color", EnumColor.class);

    public BlockBubbledStone(){
        super("bubbled_stone", Material.ROCK, 10);
        GameRegistry.register(this);
        this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumColor.DEFAULT));
    }

    @Override
    public int damageDropped(IBlockState state){
        EnumColor enumColor = (EnumColor)state.getValue(COLOR);
        return enumColor.getID();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list){
        EnumColor[] allColors = EnumColor.values();
        for(EnumColor color : allColors){
            list.add(new ItemStack(itemIn, 1, color.getID()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        EnumColor color = EnumColor.byMetadata(meta);
        return this.getDefaultState().withProperty(COLOR, color);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        EnumColor color = (EnumColor)state.getValue(COLOR);
        return color.getID();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{COLOR});
    }

    @Override
    public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        EnumColor color = EnumColor.byMetadata(meta);
        return this.getDefaultState().withProperty(COLOR, color);
    }



}
