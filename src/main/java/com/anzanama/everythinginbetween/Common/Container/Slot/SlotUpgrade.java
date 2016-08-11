package com.anzanama.everythinginbetween.Common.Container.Slot;

import com.anzanama.everythinginbetween.Common.item.ItemUpgrade;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

/**
 * Created by Andrew Graber on 8/11/2016.
 */
public class SlotUpgrade extends Slot{

    public SlotUpgrade(IInventory inventoryIn, int index, int xPosition, int yPosition){
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(@Nullable ItemStack itemStack){
        return itemStack.getItem() instanceof ItemUpgrade;
    }

}
