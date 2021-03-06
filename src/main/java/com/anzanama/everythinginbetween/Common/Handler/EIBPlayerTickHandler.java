package com.anzanama.everythinginbetween.Common.Handler;

import com.anzanama.everythinginbetween.Common.item.ItemsEIB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Andrew Graber on 8/10/2016.
 */
public class EIBPlayerTickHandler {

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event){
        if(event.side == Side.SERVER && event.phase == TickEvent.Phase.END) {
            if (event.player instanceof EntityPlayer) {
                if (event.player.inventory.hasItemStack(new ItemStack(ItemsEIB.aether_star)) && event.player.getEntityData().getInteger("joules") > 0) {
                    event.player.capabilities.allowFlying = true;
                    event.player.sendPlayerAbilities();
                    event.player.getEntityData().setBoolean("eibflying", true);
                } else if (event.player.getEntityData().getBoolean("eibflying") && !(event.player.inventory.hasItemStack(new ItemStack(ItemsEIB.aether_star)))) {
                    if (event.player.getEntityData().getBoolean("eibflying")) {
                        event.player.capabilities.allowFlying = false;
                        event.player.capabilities.isFlying = false;
                        event.player.sendPlayerAbilities();
                        event.player.getEntityData().setBoolean("eibflying", false);
                    }
                } else if( event.player.inventory.hasItemStack(new ItemStack(ItemsEIB.aether_star)) && event.player.getEntityData().getInteger("joules") <= 0){
                    if(event.player.getEntityData().getBoolean("eibflying")){
                        event.player.capabilities.allowFlying = false;
                        event.player.capabilities.isFlying = false;
                        event.player.sendPlayerAbilities();
                        event.player.getEntityData().setBoolean("eibflying", false);
                    }
                }
                if(event.player.getEntityData().getBoolean("eibflying") && event.player.capabilities.isFlying){
                    event.player.getEntityData().setInteger("joules", event.player.getEntityData().getInteger("joules") - 1);
                }
            }
        }
        if(event.side == Side.CLIENT && event.phase == TickEvent.Phase.END){
            
        }
    }
}
