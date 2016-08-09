package com.anzanama.everythinginbetween.client;

import com.anzanama.everythinginbetween.common.EIBCommonProxy;
import com.anzanama.everythinginbetween.common.item.ItemsEIB;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Andrew Graber on 8/8/2016.
 */
public class EIBClientProxy extends EIBCommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event){
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event){
        super.init(event);
        ItemsEIB.registerRenders();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event){
        super.postInit(event);
    }
}
