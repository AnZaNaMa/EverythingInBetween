package com.anzanama.everythinginbetween.Common.Container;

import com.anzanama.everythinginbetween.Common.Container.Slot.SlotUpgrade;
import com.anzanama.everythinginbetween.Common.Inventory.InventoryPersonalGenerator;
import com.anzanama.everythinginbetween.Common.item.ItemUpgrade;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumHand;

/**
 * Created by Andrew Graber on 8/11/2016.
 */
public class ContainerPersonalGenerator extends Container {
    /** The Item Inventory for this Container, only needed if you want to reference isUseableByPlayer */
    public final InventoryPersonalGenerator inventory;

    /** Using these will make transferStackInSlot easier to understand and implement
     * INV_START is the index of the first slot in the Player's Inventory, so our
     * InventoryPersonalGenerator's number of slots (e.g. 5 slots is array indices 0-4, so start at 5)
     * Notice how we don't have to remember how many slots we made? We can just use
     * InventoryPersonalGenerator.INV_SIZE and if we ever change it, the Container updates automatically. */
    private static final int INV_START = InventoryPersonalGenerator.INV_SIZE, INV_END = INV_START+26,
            HOTBAR_START = INV_END+1, HOTBAR_END = HOTBAR_START+8;

    // If you're planning to add armor slots, put those first like this:
    // ARMOR_START = InventoryPersonalGenerator.INV_SIZE, ARMOR_END = ARMOR_START+3,
    // INV_START = ARMOR_END+1, and then carry on like above.

    public ContainerPersonalGenerator(EntityPlayer player, InventoryPlayer inventoryPlayer, InventoryPersonalGenerator inventoryPersonalGenerator)
    {
        this.inventory = inventoryPersonalGenerator;

        int i;

        //Custom Inventory Slots
        this.addSlotToContainer(new SlotFurnaceFuel(this.inventory, 0, 28, 34));
        for (i = 1; i < InventoryPersonalGenerator.INV_SIZE; ++i)
        {
            this.addSlotToContainer(new SlotUpgrade(this.inventory, i, 152, 17+(18*i-18)));
        }

        //Player's Inventory Slots
        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // Player Hotbar
        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return inventory.isUseableByPlayer(entityplayer);
    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int index)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < INV_START)
            {
                if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END+1, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else
            {
				if (TileEntityFurnace.isItemFuel(itemstack1) || SlotFurnaceFuel.isBucket(itemstack1))
				{
					if (!this.mergeItemStack(itemstack1, 0, 1, false))
					{
						return null;
					}
				}
                else if(itemstack1.getItem() instanceof ItemUpgrade){
                    if (!this.mergeItemStack(itemstack1, 1, InventoryPersonalGenerator.INV_SIZE, false))
                    {
                        return null;
                    }
                }
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack) null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }

    @Override
    public ItemStack slotClick(int slot, int button, ClickType clickTypeIn, EntityPlayer player) {
        // this will prevent the player from interacting with the item that opened the inventory:
        if (slot >= 0 && getSlot(slot) != null && getSlot(slot).getStack() == player.getHeldItem(EnumHand.MAIN_HAND)) {
            return null;
        }
        return super.slotClick(slot, button, clickTypeIn, player);
    }


}
