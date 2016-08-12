package com.anzanama.everythinginbetween.Common.Block;

import com.anzanama.everythinginbetween.Common.item.ItemsEIB;
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

    public static void addBlocks(){
        bubbled_stone = new BlockBubbledStone();
    }

    public static void registerRenders(){
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender(Block block, int meta) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    public static void registerSpecialRenders(){
        ModelResourceLocation r = new ModelResourceLocation("bubbled_stone_default", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.DEFAULT.getID(), r);

        r = new ModelResourceLocation("bubbled_stone_white", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.WHITE.getID(), r);

        r = new ModelResourceLocation("bubbled_stone_black", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.BLACK.getID(), r);

        r = new ModelResourceLocation("bubbled_stone_blue", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.BLUE.getID(), r);

        r = new ModelResourceLocation("bubbled_stone_green", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.GREEN.getID(), r);

        r = new ModelResourceLocation("bubbled_stone_orange", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.ORANGE.getID(), r);

        r = new ModelResourceLocation("bubbled_stone_yellow", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.YELLOW.getID(), r);

        r = new ModelResourceLocation("bubbled_stone_teal", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.TEAL.getID(), r);

        r = new ModelResourceLocation("bubbled_stone_lightblue", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTBLUE.getID(), r);

        r = new ModelResourceLocation("bubbled_stone_lightgreen", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTGREEN.getID(), r);

        r = new ModelResourceLocation("bubbled_stone_lightorange", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTORANGE.getID(), r);

        r = new ModelResourceLocation("bubbled_stone_lightyellow", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTYELLOW.getID(), r);

        r = new ModelResourceLocation("bubbled_stone_lightteal", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTTEAL.getID(), r);

        r = new ModelResourceLocation("bubbled_stone_lightpink", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTPINK.getID(), r);

        r = new ModelResourceLocation("bubbled_stone_lightviolet", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTVIOLET.getID(), r);

        r = new ModelResourceLocation("bubbled_stone_lightred", "inventory");
        ModelLoader.setCustomModelResourceLocation(ItemsEIB.item_block_bubbled_stone, EnumColor.LIGHTRED.getID(), r);
    }

}
