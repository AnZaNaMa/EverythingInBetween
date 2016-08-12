package com.anzanama.everythinginbetween.Common.item;

import com.anzanama.everythinginbetween.Common.Block.EnumColor;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew Graber on 8/12/2016.
 */
public class ItemBlockVariants extends ItemBlock {

    public ItemBlockVariants(Block block){
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        GameRegistry.register(this);
    }

    @Override
    public int getMetadata(int metadata){
        return metadata;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack){
        EnumColor color = EnumColor.byMetadata(stack.getMetadata());
        return super.getUnlocalizedName() + "." + color.toString();
    }

}
