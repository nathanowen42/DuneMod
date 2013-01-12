package net.minecraft.src;
import java.util.Random;

public class DuneWorldGenOutcroppings extends WorldGenerator
{
    public DuneWorldGenOutcroppings()
    {
    }
    public boolean generate(World par1World, Random par2Random, int xStart, int yStart, int zStart)
    {
        BiomeGenBase biome = par1World.getWorldChunkManager().getBiomeGenAt(xStart, yStart);

        if (!(biome instanceof BiomeGenDune))
        {
            return false;
        }
        else
        {
            int length = 60;
            int width = 40;
            double y = 0;
            double w = 0;
            int x = 0;
            int startHeight = 40;
            Random rand = new Random();
            int k = rand.nextInt(30) + 85;
            double a = Math.random() * .4;
            double t = Math.random() * .4;
            double minA = .008;
            double minT = .05;

            if (t > a)
            {
                double u = t;
                t = a;
                a = u;
            }

            if (a < minA)
            {
                a = minA;
            }

            if (t < minT)
            {
                t = minT;
            }

            if ((a / 3) > t)
            {
                t = a / 3;
            }

            if (t > a)
            {
                double u = t;
                t = a;
                a = u;
            }

            while (y >= 0)
            {
                int n = 1;
                int p = 0;
                y = (-a * ((x) * (x))) + k;
                int noise = (int)Math.round(Math.random() * 6 - 3);
                int noise2 = (int)Math.round(Math.random() * 6 - 3);

                while (n >= 0)
                {
                    int noise3 = (int)Math.round(Math.random());
                    int noise4 = (int)Math.round(Math.random());
                    int noise5 = (int)Math.round(Math.random());
                    int noise6 = (int)Math.round(Math.random());
                    n = (int) Math.round((-t * ((p) * (p))) + y);

                    for (int r = 0; r <= n; r++)
                    {
                        Material var13 = par1World.getBlockMaterial(xStart + p, r + startHeight + noise + noise3, yStart + x);

                        if (var13 == Material.sand || var13 == Material.air)
                        {
                            par1World.setBlockWithNotify(xStart + p, r + startHeight + noise + noise3, yStart + x, Block.stone.blockID);
                        }

                        var13 = par1World.getBlockMaterial(xStart - p, r + startHeight + noise + noise4, yStart + x);

                        if (var13 == Material.sand || var13 == Material.air)
                        {
                            par1World.setBlockWithNotify(xStart - p, r + startHeight + noise + noise4, yStart + x, Block.stone.blockID);
                        }

                        var13 = par1World.getBlockMaterial(xStart + p, r + startHeight + noise2 + noise5, yStart - x);

                        if (var13 == Material.sand || var13 == Material.air)
                        {
                            par1World.setBlockWithNotify(xStart + p, r + startHeight + noise2 + noise5, yStart - x, Block.stone.blockID);
                        }

                        var13 = par1World.getBlockMaterial(xStart - p, r + startHeight + noise2 + noise6, yStart - x);

                        if (var13 == Material.sand || var13 == Material.air)
                        {
                            par1World.setBlockWithNotify(xStart - p, r + startHeight + noise2 + noise6, yStart - x, Block.stone.blockID);
                        }
                    }

                    p++;
                }

                x++;
            }

            return true;
        }
    }
}