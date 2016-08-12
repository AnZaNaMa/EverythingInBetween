package com.anzanama.everythinginbetween.Common.WorldGen;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by Andrew Graber on 8/12/2016.
 */
public class EIBWorldGeneration implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimension()){
            case -1:
                generateNether(world, random, chunkX*16, chunkZ*16);
                break;
            case 0:
                generateOverworld(world, random, chunkX*16, chunkZ*16);
                break;
            case 1:
                generateEnd(world, random, chunkX*16, chunkZ*16);
                break;
        }
    }

    private void generateNether(World world, Random random, int chunkX, int chunkZ){

    }

    private void generateOverworld(World world, Random random, int chunkX, int chunkZ){

    }

    private void generateEnd(World world, Random random, int chunkX, int chunkZ){

    }
}
