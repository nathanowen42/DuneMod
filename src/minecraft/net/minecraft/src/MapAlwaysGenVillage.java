package net.minecraft.src;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MapAlwaysGenVillage extends MapGenStructure
{
    /** A list of all the biomes villages can spawn in. */
    public static List villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] {BiomeGenBase.dune});

    /** World terrain type, 0 for normal, 1 for flat map */
    private final int terrainType;

    public MapAlwaysGenVillage(int par1)
    {
        this.terrainType = par1;
    }

    protected boolean canSpawnStructureAtCoords(int par1, int par2)
    {
        byte var3 = 32;
        byte var4 = 8;
        int var5 = par1;
        int var6 = par2;

        if (par1 < 0)
        {
            par1 -= var3 - 1;
        }

        if (par2 < 0)
        {
            par2 -= var3 - 1;
        }

        if (par1%375 == 0 && par2%375 == 0)
        {
            boolean var10 = this.worldObj.getWorldChunkManager().areBiomesViable(var5 * 16 + 8, var6 * 16 + 8, 0, villageSpawnBiomes);

            if (var10)
            {
                return true;
            }
        }

        return false;
    }

    protected StructureStart getStructureStart(int par1, int par2)
    {
        return new StructureVillageStartDune(this.worldObj, this.rand, par1, par2, this.terrainType);
    }
}
