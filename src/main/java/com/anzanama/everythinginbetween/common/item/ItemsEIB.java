package com.anzanama.everythinginbetween.Common.item;

import com.anzanama.everythinginbetween.Common.Block.BlocksEIB;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Andrew Graber on 8/8/2016.
 */
public class ItemsEIB {

    public static Item aether_star;
    public static Item personal_generator;
    public static Item energy_monitor;

    public static ItemBlockBubbledStone item_block_bubbled_stone;
    public static ItemBlock item_block_player_augmentor;

    public static void addItems() {
        aether_star = new ItemAetherStar();
        personal_generator = new ItemPersonalGenerator();
        energy_monitor = new ItemEnergyMonitor();
        item_block_bubbled_stone = new ItemBlockBubbledStone(BlocksEIB.bubbled_stone);
        GameRegistry.register(item_block_bubbled_stone);
        item_block_player_augmentor = new ItemBlock(BlocksEIB.player_augmentor);
        item_block_player_augmentor.setUnlocalizedName("item_block_player_augmentor");
        item_block_player_augmentor.setRegistryName("item_block_player_augmentor");
        GameRegistry.register(item_block_player_augmentor);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders(){
        registerRender(aether_star);
        registerRender(personal_generator);
        registerRender(energy_monitor);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}
