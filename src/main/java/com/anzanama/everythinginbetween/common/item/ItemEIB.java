package com.anzanama.everythinginbetween.common.item;

import net.minecraft.item.Item;

/**
 * Created by Andrew Graber on 8/8/2016.
 */
public class ItemEIB extends Item {

    public String getName(){
        return this.getUnlocalizedName().substring(5);
    }
}
