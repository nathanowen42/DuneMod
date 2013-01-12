package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BiomeGenDune extends BiomeGenBase
{
    public BiomeGenDune(int par1)
    {
        super(par1);
        spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        topBlock = (byte)Block.sand.blockID;
        fillerBlock = (byte)Block.sand.blockID;
        //biomeDecorator.treesPerChunk = -999;
        //biomeDecorator.deadBushPerChunk = 2;
        //biomeDecorator.reedsPerChunk = 50;
        //biomeDecorator.cactiPerChunk = 10;
        temperature = 80.0F;
    }

    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);

        if (par2Random.nextInt(1000) == 0)
        {
            int var5 = par3 + par2Random.nextInt(16) + 8;
            int var6 = par4 + par2Random.nextInt(16) + 8;
            //WorldGenDesertWells var7 = new WorldGenDesertWells();
            //var7.generate(par1World, par2Random, var5, par1World.getHeightValue(var5, var6) + 1, var6);
        }
    }
    public int getSkyColorByTemp(float par1)
    {
        return java.awt.Color.getHSBColor(2.095F, .607F, 1F).getRGB();
    }
}
