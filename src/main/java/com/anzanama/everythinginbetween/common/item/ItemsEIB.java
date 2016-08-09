package com.anzanama.everythinginbetween.common.item;

import com.anzanama.everythinginbetween.EverythingInBetween;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Andrew Graber on 8/8/2016.
 */
public class ItemsEIB {

    public static Item aether_star;

    public static void addItems() {
        aether_star = new ItemAetherStar();
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders(){
        registerRender(aether_star);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}
