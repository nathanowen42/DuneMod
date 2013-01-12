package net.minecraft.src;
import java.util.Random;

public class DuneWorldGenPillerTester extends WorldGenerator
{
    public DuneWorldGenPillerTester()
    {
    }
    public boolean generate(World par1World, Random par2Random, int xStart, int yStart, int zStart)
    {
        BiomeGenBase biome = par1World.getWorldChunkManager().getBiomeGenAt(xStart, yStart);

        if (!(biome instanceof BiomeGenDune))
        {
            return false;
        }

        for (int i = 0; i < 200; i++)
        {
            par1World.setBlockWithNotify(xStart, i, yStart, Block.obsidian.blockID);
        }

        return true;
    }
}