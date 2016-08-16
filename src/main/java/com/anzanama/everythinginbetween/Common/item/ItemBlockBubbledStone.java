package com.anzanama.everythinginbetween.Common.item;

import com.anzanama.everythinginbetween.Common.Block.EnumColor;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew Graber on 8/12/2016.
 */
public class ItemBlockBubbledStone extends ItemBlock {

    public ItemBlockBubbledStone(Block block){
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setUnlocalizedName("item_block_bubbled_stone");
        this.setRegistryName("item_block_bubbled_stone");
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
