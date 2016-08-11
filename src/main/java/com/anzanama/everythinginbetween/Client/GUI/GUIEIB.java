package com.anzanama.everythinginbetween.Client.GUI;

import com.anzanama.everythinginbetween.Client.GUI.Handler.GUIHandlerPersonalGenerator;
import com.anzanama.everythinginbetween.EverythingInBetween;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by Andrew Graber on 8/11/2016.
 */
public class GUIEIB {

    private static int GuiIndex = 0;

    public static final int GUI_ITEM_INV = GuiIndex++;

    public static void registerGuiHandlers(){
        registerHandler(new GUIHandlerPersonalGenerator());
    }

    private static void registerHandler(IGuiHandler handler){
        NetworkRegistry.INSTANCE.registerGuiHandler(EverythingInBetween.instance, handler);
    }
}
