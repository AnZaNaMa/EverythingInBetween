package com.anzanama.everythinginbetween.Common.item;

import com.anzanama.everythinginbetween.EverythingInBetween;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew Graber on 8/8/2016.
 */
public class ItemAetherStar extends ItemEIB {

    public ItemAetherStar(){
        this.setRegistryName("aether_star");
        this.setUnlocalizedName("aether_star");
        this.setCreativeTab(EverythingInBetween.tab);
        this.setMaxStackSize(1);
        GameRegistry.register(this);
    }
}
