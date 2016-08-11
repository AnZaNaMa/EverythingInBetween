package com.anzanama.everythinginbetween.Client.GUI.Handler;

import com.anzanama.everythinginbetween.Client.GUI.GUIEIB;
import com.anzanama.everythinginbetween.Client.GUI.GUIPersonalGenerator;
import com.anzanama.everythinginbetween.Common.Container.ContainerPersonalGenerator;
import com.anzanama.everythinginbetween.Common.Inventory.InventoryPersonalGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by Andrew Graber on 8/11/2016.
 */
public class GUIHandlerPersonalGenerator implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z){
        if(guiId == GUIEIB.GUI_ITEM_INV){
            return new ContainerPersonalGenerator(player, player.inventory, new InventoryPersonalGenerator(player.getHeldItemMainhand()));
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z){
        if(guiId == GUIEIB.GUI_ITEM_INV){
            return new GUIPersonalGenerator((ContainerPersonalGenerator) new ContainerPersonalGenerator(player, player.inventory, new InventoryPersonalGenerator(player.getHeldItemMainhand())), player);
        }
        return null;
    }
}
