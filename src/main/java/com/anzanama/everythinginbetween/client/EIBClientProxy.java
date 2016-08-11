package com.anzanama.everythinginbetween.Client;

import com.anzanama.everythinginbetween.Common.EIBCommonProxy;
import com.anzanama.everythinginbetween.Common.item.ItemsEIB;
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
        ItemsEIB.registerRenders();
    }

    @Override
    public void init(FMLInitializationEvent event){
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event){
        super.postInit(event);
    }
}
