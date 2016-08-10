package com.anzanama.everythinginbetween.common.item;

import com.anzanama.everythinginbetween.EverythingInBetween;
import com.anzanama.everythinginbetween.util.PlayerChecker;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
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

    @SubscribeEvent
    public void onPlayerUpdate(TickEvent.PlayerTickEvent event){
        if(event.player instanceof EntityPlayer){
            if(PlayerChecker.checkInvForItem(event.player, ItemsEIB.aether_star)){
                event.player.capabilities.allowFlying = true;
                event.player.sendPlayerAbilities();
                event.player.getEntityData().setBoolean("eibflying", true);
            } else if(event.player.capabilities.allowFlying && !(PlayerChecker.checkInvForItem(event.player, ItemsEIB.aether_star))){
                if(event.player.getEntityData().getBoolean("eibflying")){
                    event.player.capabilities.allowFlying = false;
                    event.player.sendPlayerAbilities();
                    event.player.getEntityData().setBoolean("eibflying", false);
                }
            }
        }
    }
}
