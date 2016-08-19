package com.anzanama.everythinginbetween.Common.Block;

import com.anzanama.everythinginbetween.Common.item.ItemsEIB;
import com.anzanama.everythinginbetween.EverythingInBetween;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Andrew Graber on 8/12/2016.
 */
public class BlocksEIB {

    public static Block bubbled_stone;
    public static Block player_augmentor;

    public static void addBlocks(){
        bubbled_stone = new BlockBubbledStone();
        player_augmentor = new BlockPlayerAugmentor();
    }

    public static void registerRenders(){
        registerRender(player_augmentor, 0);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender(Block block, int meta) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    public static void registerSpecialRenders(){
        ModelResourceLocation r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=default");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.DEFAULT.getID(), r);

        r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=white");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.WHITE.getID(), r);

        r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=black");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.BLACK.getID(), r);

        r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=blue");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.BLUE.getID(), r);

        r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=green");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.GREEN.getID(), r);

        r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=orange");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.ORANGE.getID(), r);

        r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=yellow");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.YELLOW.getID(), r);

        r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=teal");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.TEAL.getID(), r);

        r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=lightblue");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTBLUE.getID(), r);

        r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=lightgreen");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTGREEN.getID(), r);

        r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=lightorange");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTORANGE.getID(), r);

        r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=lightyellow");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTYELLOW.getID(), r);

        r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=lightteal");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTTEAL.getID(), r);

        r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=lightpink");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTPINK.getID(), r);

        r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=lightviolet");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTVIOLET.getID(), r);

        r = new ModelResourceLocation(EverythingInBetween.MODID + ":bubbled_stone", "color=lightred");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTRED.getID(), r);
    }

}
