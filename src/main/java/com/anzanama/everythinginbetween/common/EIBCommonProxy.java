package com.anzanama.everythinginbetween.Common;

import com.anzanama.everythinginbetween.Client.GUI.GUIEIB;
import com.anzanama.everythinginbetween.Common.Block.BlocksEIB;
import com.anzanama.everythinginbetween.Common.Handler.EIBPlayerTickHandler;
import com.anzanama.everythinginbetween.Common.item.ItemsEIB;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Andrew Graber on 8/8/2016.
 */
public class EIBCommonProxy {

    public void preInit(FMLPreInitializationEvent event)
    {
        BlocksEIB.addBlocks();
        ItemsEIB.addItems();
    }

    public void init(FMLInitializationEvent event)
    {
        //Register Player Tick Handler
        FMLCommonHandler.instance().bus().register(new EIBPlayerTickHandler());
        GUIEIB.registerGuiHandlers();
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }

}
