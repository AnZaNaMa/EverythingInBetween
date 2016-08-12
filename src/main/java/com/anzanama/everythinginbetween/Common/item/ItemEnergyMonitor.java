package com.anzanama.everythinginbetween.Common.item;

import com.anzanama.everythinginbetween.Client.GUI.GUIEIB;
import com.anzanama.everythinginbetween.EverythingInBetween;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew Graber on 8/11/2016.
 */
public class ItemEnergyMonitor extends ItemEIB {

    public ItemEnergyMonitor(){
        this.setMaxStackSize(1);
        this.setRegistryName("energy_monitor");
        this.setUnlocalizedName("energy_monitor");
        this.setCreativeTab(EverythingInBetween.tab);
        GameRegistry.register(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemstack, World world, EntityPlayer player, EnumHand enumHand){
        if(!world.isRemote && !player.isSneaking()){
            player.addChatMessage(new TextComponentString("Energy: " + player.getEntityData().getInteger("joules") + "J"));
        }
        else if(!world.isRemote &&  player.isSneaking()){
            player.getEntityData().setInteger("joules", player.getEntityData().getInteger("joules") + 10);
        }
        return new ActionResult(EnumActionResult.PASS, itemstack);
    }

}
