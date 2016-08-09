package com.anzanama.everythinginbetween;

import com.anzanama.everythinginbetween.client.EIBClientProxy;
import com.anzanama.everythinginbetween.common.EIBCommonProxy;
import com.anzanama.everythinginbetween.common.item.ItemsEIB;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = EverythingInBetween.MODID, name = EverythingInBetween.NAME, version = EverythingInBetween.VERSION)
public class EverythingInBetween
{
    public static final String MODID = "everythinginbetween";
    public static final String VERSION = "1.0";
    public static final String NAME = "Everything In Between";

    @Mod.Instance(EverythingInBetween.MODID)
    public static EverythingInBetween instance;

    @SidedProxy(clientSide = "com.anzanama.everythinginbetween.client.EIBClientProxy", serverSide = "com.anzanama.everythinginbetween.common.EIBCommonProxy")
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
