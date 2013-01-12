package net.minecraft.src;

import java.util.Random;

public class DuneWorldGenSheildWall extends WorldGenerator
{
    public DuneWorldGenSheildWall()
    {
    }

    public boolean generate(World par1World, Random par2Random, int xStart,
            int yStart, int z)
    {
        BiomeGenBase biome = par1World.getWorldChunkManager().getBiomeGenAt(xStart, yStart);

        if (!(biome instanceof BiomeGenDune))
        {
            return false;
        }

        int radius = 100;
        int[][] grider = DuneCircleArrayMaker.circleOutline(radius);
        createMountainInChain(xStart, yStart, grider, par1World, par2Random, radius);
        return true;
    }

    public void createMountainInChain(int xStart, int yStart, int grider[][], World par1World, Random par2Random, int radius)
    {
        Random rand = new Random();
        int arraySize = (radius * 2) + 2;
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
                    tester = grider[xer + x][yer + y];
                }
                catch (Exception outOfBounds)
                {
                    tester = 0;
                    // System.out.println("Out of bounds exception in DuneWorldGenFlattener");
                }

                if (tester == 1)
                {
                    int rareness = rand.nextInt(3);

                    if (rareness == 1)
                    {
                        generateMount(par1World, par2Random, x + xStart, y + yStart);
                    }
                }
            }
        }
    }

    public void generateMount(World par1World, Random par2Random, int xStart,
            int yStart)
    {
        BiomeGenBase biome = par1World.getWorldChunkManager().getBiomeGenAt(xStart, yStart);
        double y = 0;
        int x = 0;
        int startHeight = 40;
        Random rand = new Random();
        int k = rand.nextInt(15) + 75;
        double a = .3 + Math.random() * .1;

        while (y >= 0)
        {
            int n = 1;
            int p = 0;
            y = (-a * ((x) * (x))) + k;

            while (n >= 0)
            {
                int noise3 = (int) Math.round(Math.random());
                int noise4 = (int) Math.round(Math.random());
                int noise5 = (int) Math.round(Math.random());
                int noise6 = (int) Math.round(Math.random());
                n = (int) Math.round((-a * ((p) * (p))) + y);

                for (int r = 0; r <= n; r++)
                {
                    par1World.setBlockWithNotify(xStart + p, r + startHeight + noise3, yStart + x, Block.stone.blockID);
                    par1World.setBlockWithNotify(xStart - p, r + startHeight + noise4, yStart + x, Block.stone.blockID);
                    par1World.setBlockWithNotify(xStart + p, r + startHeight + noise5, yStart - x, Block.stone.blockID);
                    par1World.setBlockWithNotify(xStart - p, r + startHeight + noise6, yStart - x, Block.stone.blockID);
                }

                p++;
            }

            x++;
        }
    }
}