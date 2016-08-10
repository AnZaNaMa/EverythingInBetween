package com.anzanama.everythinginbetween.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

/**
 * Created by Andrew Graber on 8/9/2016.
 */
public class PlayerChecker {

    public static boolean checkInvForItem(EntityPlayer player,Item item){
        boolean hasItem = false;
        for(int i=0; i < player.inventory.getSizeInventory(); i++){
            if(player.inventory.getStackInSlot(i).getItem().equals(item)){
                hasItem = true;
            }
        }
        return hasItem;
    }

}
