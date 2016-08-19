package com.anzanama.everythinginbetween.Common.tile;

import com.anzanama.everythinginbetween.EverythingInBetween;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew Graber on 8/16/2016.
 */
public class TileEIB {

    public static void register(){
        GameRegistry.registerTileEntity(TilePlayerAugmentor.class, EverythingInBetween.MODID + ":tile_player_augmentor");
    }

}
