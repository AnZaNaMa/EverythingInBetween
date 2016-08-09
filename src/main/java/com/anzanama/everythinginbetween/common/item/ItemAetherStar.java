package com.anzanama.everythinginbetween.common.item;

import com.anzanama.everythinginbetween.EverythingInBetween;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew Graber on 8/8/2016.
 */
public class ItemAetherStar extends ItemEIB {

    public ItemAetherStar(){
        this.setRegistryName("aether_star");
        this.setUnlocalizedName("aether_star");
        this.setCreativeTab(EverythingInBetween.tab);
        GameRegistry.register(this);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected){
        if(entity instanceof EntityPlayer){
            ((EntityPlayer) entity).capabilities.allowFlying = true;
        }
    }
}
