package com.anzanama.everythinginbetween.Common.item;

import com.anzanama.everythinginbetween.Client.GUI.GUIEIB;
import com.anzanama.everythinginbetween.EverythingInBetween;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew Graber on 8/11/2016.
 */
public class ItemPersonalGenerator extends ItemEIB {

    public ItemPersonalGenerator(){
        this.setRegistryName("personal_generator");
        this.setUnlocalizedName("personal_generator");
        this.setCreativeTab(EverythingInBetween.tab);
        this.setMaxStackSize(1);
        GameRegistry.register(this);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected){
        /*
        ItemStack fuelStack = ItemStack.loadItemStackFromNBT(stack.getTagCompound().getTagList("ItemInventory", Constants.NBT.TAG_COMPOUND).getCompoundTagAt(0));

        if(entityIn instanceof EntityPlayer && !worldIn.isRemote) {
            ((EntityPlayer)entityIn).addChatMessage(new TextComponentString("Is player and Server Side."));
            entityIn.addChatMessage(new TextComponentString("Ticks Left: " + stack.getTagCompound().getInteger("ticks")));
            if (stack.getTagCompound().getInteger("ticks") <= 0) {
                if (fuelStack != null && fuelStack.stackSize > 0) {
                    entityIn.addChatMessage(new TextComponentString("PASSED!"));
                    int fuelValue = TileEntityFurnace.getItemBurnTime(fuelStack);
                    fuelStack.stackSize--;
                    stack.getTagCompound().setInteger("ticks", fuelValue);
                    stack.getTagCompound().setInteger("maxticks", fuelValue);
                }
            } else if (stack.getTagCompound().getInteger("ticks") > 0) {
                ((EntityPlayer)entityIn).getEntityData().setInteger("joules", ((EntityPlayer)entityIn).getEntityData().getInteger("joules") + 1);
                stack.getTagCompound().setInteger("ticks", stack.getTagCompound().getInteger("ticks") - 1);
            }
        }
        */
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack){
        return 1;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemstack, World world, EntityPlayer player, EnumHand enumHand){
        if(!world.isRemote){
            player.addChatMessage(new TextComponentString("Opening GUI..."));
            player.openGui(EverythingInBetween.instance, GUIEIB.GUI_ITEM_INV, world, 0, 0, 0);
        }
        return new ActionResult(EnumActionResult.PASS, itemstack);
    }

    public static int getPercentFuelUsed(ItemStack stack){
        if(stack.getItem() == ItemsEIB.personal_generator){
            int maxticks = stack.getTagCompound().getInteger("maxticks");
            int currentticks = stack.getTagCompound().getInteger("ticks");
            return (int)((((double)maxticks-(double)currentticks)/(double)maxticks)*100.0D);
        }
        else return 100;
    }



}
