package com.anzanama.everythinginbetween.Common.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Andrew Graber on 8/8/2016.
 */
public class ItemsEIB {

    public static Item aether_star;
    public static Item personal_generator;

    public static void addItems() {
        aether_star = new ItemAetherStar();
        personal_generator = new ItemPersonalGenerator();
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders(){
        registerRender(aether_star);
        registerRender(personal_generator);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}
