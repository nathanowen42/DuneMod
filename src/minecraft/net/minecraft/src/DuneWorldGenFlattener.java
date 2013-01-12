package net.minecraft.src;

import java.util.Random;

public class DuneWorldGenFlattener extends WorldGenerator
{
    public DuneWorldGenFlattener()
    {
    }

    public boolean generate(World par1World, Random par2Random, int xStart, int yStart, int zStart)
    {
        BiomeGenBase biome = par1World.getWorldChunkManager().getBiomeGenAt(
                xStart, yStart);

        if (!(biome instanceof BiomeGenDune))
        {
            return false;
        }
        else
        {
            int radius = 100;
            int circleStencle[][] = DuneCircleArrayMaker.circleFilled(radius);
            int arraySize = (radius * 2) + 2;
            int minZ = 40; // height of base
            int height = 120; // height of top
            int par1 = xStart % 6000;
            int par2 = yStart % 6000;
            int xer = par1 + (int) Math.ceil(arraySize / 2);
            int yer = par2 + (int) Math.ceil(arraySize / 2);

            for (int x = 0; x < 16; x++)
            {
                for (int y = 0; y < 16; y++)
                {
                    int tester = 0;

                    try
                    {
                        tester = circleStencle[xer + x][yer + y];
                    }
                    catch (Exception outOfBounds)
                    {
                        tester = 0;
                        // System.out.println("Out of bounds exeption in DuneWorldGenFlattener");
                    }

                    if (tester == 1)
                    {
                        int currentZ = minZ; // current vertical generation level

                        for (int z = minZ; z <= height; z++)
                        {
                            Material var13 = par1World.getBlockMaterial(xStart + x, z, yStart + y);

                            if (var13 == Material.sand || var13 == Material.air)
                            {
                                if (currentZ < 97)
                                {
                                    par1World.setBlockWithNotify(xStart + x, z, yStart + y, Block.stone.blockID);
                                }
                                else if (currentZ == 97)
                                {
                                    par1World.setBlockWithNotify(xStart + x, z, yStart + y, Block.sand.blockID);
                                }
                                else if (var13 == Material.sand)
                                {
                                    par1World.setBlockWithNotify(xStart + x, z, yStart + y, 0);
                                }
                            }

                            currentZ++;
                        }
                    }
                }
            }

            return true;
        }
    }
}
