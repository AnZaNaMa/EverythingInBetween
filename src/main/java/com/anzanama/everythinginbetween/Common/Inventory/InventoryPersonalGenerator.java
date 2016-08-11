package com.anzanama.everythinginbetween.Common.Inventory;

import com.anzanama.everythinginbetween.Common.item.ItemPersonalGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.util.Constants;

/**
 * Created by Andrew Graber on 8/11/2016.
 */
public class InventoryPersonalGenerator implements IInventory {

    private String name = "Personal Generator";

    private final ItemStack invItem;

    public static final int INV_SIZE = 4;

    private ItemStack[] inventory = new ItemStack[INV_SIZE];

    public InventoryPersonalGenerator(ItemStack masterStack){

        invItem = masterStack;

        if(!masterStack.hasTagCompound()){
            masterStack.setTagCompound(new NBTTagCompound());
        }

        readFromNBT(masterStack.getTagCompound());

    }

    @Override
    public int getSizeInventory(){
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot){
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount){
        ItemStack stack = getStackInSlot(slot);
        if(stack != null){
            if(stack.stackSize > amount){
                stack = stack.splitStack(amount);
                markDirty();
            } else {
                setInventorySlotContents(slot, null);
            }
        }
        return stack;
    }

    @Override
    public ItemStack removeStackFromSlot(int slot){
        ItemStack stack = getStackInSlot(slot);
        setInventorySlotContents(slot, null);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack){
        inventory[slot] = stack;

        if(stack != null && stack.stackSize > getInventoryStackLimit()){
            stack.stackSize = getInventoryStackLimit();
        }
        markDirty();
    }

    @Override
    public int getInventoryStackLimit(){
        return 64;
    }

    @Override
    public void markDirty(){
        for(int i = 0; i < getSizeInventory(); ++i){
            if(getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0) {
                inventory[i] = null;
            }
        }
        writeToNBT(invItem.getTagCompound());
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer){
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player){}

    @Override
    public void closeInventory(EntityPlayer player){}

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack){
        return !(itemstack.getItem() instanceof ItemPersonalGenerator);
    }

    public void readFromNBT(NBTTagCompound compound){
        NBTTagList items = compound.getTagList("ItemInventory", Constants.NBT.TAG_COMPOUND);

        for(int i = 0; i < items.tagCount(); ++i){
            NBTTagCompound item = (NBTTagCompound)items.getCompoundTagAt(i);
            int slot = item.getInteger("Slot");

            if(slot >= 0 && slot < getSizeInventory()){
                inventory[slot] = ItemStack.loadItemStackFromNBT(item);
            }
        }
    }

    public void writeToNBT(NBTTagCompound compound){
        NBTTagList items = new NBTTagList();

        for(int i = 0; i < getSizeInventory(); ++i){
            if(getStackInSlot(i) != null){
                NBTTagCompound item = new NBTTagCompound();
                item.setInteger("Slot", i);
                getStackInSlot(i).writeToNBT(item);
                items.appendTag(item);
            }
        }
        compound.setTag("ItemInventory", items);
    }

    public String getInvName(){
        return name;
    }

    public boolean isInvNameLocalized(){
        return name.length() > 0;
    }

    public void clear(){
        for(int i = 0; i < inventory.length; i++){
            inventory[i] = null;
        }
    }

    @Override
    public String getName(){
        return getInvName();
    }

    @Override
    public int getField(int id){
        return 0;
    }

    @Override
    public void setField(int id, int num){}

    @Override
    public int getFieldCount(){
        return INV_SIZE;
    }

    @Override
    public boolean hasCustomName(){
        return getName() != name;
    }

    @Override
    public ITextComponent getDisplayName(){
        return new TextComponentString(getName());
    }

    public ItemStack getInvItem(){
        return invItem;
    }

}
