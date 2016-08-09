package com.anzanama.everythinginbetween.common;

import com.anzanama.everythinginbetween.common.item.ItemsEIB;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Andrew Graber on 8/8/2016.
 */
public class EIBCommonProxy {

    public void preInit(FMLPreInitializationEvent event)
    {
        ItemsEIB.addItems();
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }

}
