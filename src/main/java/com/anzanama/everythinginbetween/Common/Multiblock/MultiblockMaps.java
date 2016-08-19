package com.anzanama.everythinginbetween.Common.Multiblock;

import com.anzanama.everythinginbetween.Common.Block.BlockBubbledStone;
import com.anzanama.everythinginbetween.Common.Block.BlocksEIB;
import com.anzanama.everythinginbetween.Common.Block.EnumColor;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

/**
 * Created by Andrew Graber on 8/18/2016.
 */
public class MultiblockMaps {

    static IBlockState n = Blocks.AIR.getDefaultState();
    static IBlockState a = BlocksEIB.bubbled_stone.getDefaultState().withProperty(BlockBubbledStone.COLOR, EnumColor.GREEN);
    static IBlockState b = BlocksEIB.bubbled_stone.getDefaultState().withProperty(BlockBubbledStone.COLOR, EnumColor.LIGHTGREEN);
    static IBlockState c = BlocksEIB.bubbled_stone.getDefaultState().withProperty(BlockBubbledStone.COLOR, EnumColor.YELLOW);
    static IBlockState d = BlocksEIB.bubbled_stone.getDefaultState().withProperty(BlockBubbledStone.COLOR, EnumColor.LIGHTYELLOW);
    static IBlockState e = BlocksEIB.bubbled_stone.getDefaultState().withProperty(BlockBubbledStone.COLOR, EnumColor.BLACK);
    static IBlockState f = BlocksEIB.bubbled_stone.getDefaultState().withProperty(BlockBubbledStone.COLOR, EnumColor.WHITE);
    static IBlockState g = BlocksEIB.player_augmentor.getDefaultState();
    public static final IBlockState[][][] PlayerAugmentSpeed =
            {
                    {
                            {n, n, n, n, n},
                            {n, n, e, n, n},
                            {n, e, g, e, n},
                            {n, n, e, n, n},
                            {n, n, n, n, n}
                    },
                    {
                            {n, n, f, n, n},
                            {n, n, n, n, n},
                            {f, n, d, n, f},
                            {n, n, n, n, n},
                            {n, n, f, n, n}
                    },
                    {
                            {n, n, b, n, n},
                            {n, n, n, n, n},
                            {b, n, c, n, b},
                            {n, n, n, n, n},
                            {n, n, b, n, n}
                    },
                    {
                            {n, n, a, n, n},
                            {n, n, n, n, n},
                            {a, n, n, n, a},
                            {n, n, n, n, n},
                            {n, n, a, n, n}
                    }
            };
}
