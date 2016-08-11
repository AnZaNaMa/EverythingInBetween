package com.anzanama.everythinginbetween;

import com.anzanama.everythinginbetween.Common.EIBCommonProxy;
import com.anzanama.everythinginbetween.Common.item.ItemsEIB;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = EverythingInBetween.MODID, name = EverythingInBetween.NAME, version = EverythingInBetween.VERSION)
public class EverythingInBetween
{
    public static final String MODID = "everythinginbetween";
    public static final String VERSION = "1.0";
    public static final String NAME = "Everything In Between";

    @Mod.Instance(EverythingInBetween.MODID)
    public static EverythingInBetween instance;

    @SidedProxy(clientSide = "com.anzanama.everythinginbetween.Client.EIBClientProxy", serverSide = "com.anzanama.everythinginbetween.Common.EIBCommonProxy")
    public static EIBCommonProxy proxy;

    public static CreativeTabs tab = new CreativeTabs("everythinginbetween") {
        @Override
        public Item getTabIconItem() {
            return ItemsEIB.aether_star;
        }
    };



    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
