package com.anzanama.everythinginbetween.Common.Block;

import com.anzanama.everythinginbetween.EverythingInBetween;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Andrew Graber on 8/12/2016.
 */
public class BlockEIB extends Block {

    public BlockEIB(String unlocalizedName, Material material, int hardness){
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(unlocalizedName);
        this.setHardness(hardness);
        this.setCreativeTab(EverythingInBetween.tab);
    }

}
