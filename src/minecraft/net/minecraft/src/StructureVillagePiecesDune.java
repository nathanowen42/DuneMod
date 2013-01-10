package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StructureVillagePiecesDune
{
    public static ArrayList getStructureVillageWeightedPieceList(Random par0Random, int par1)
    {
        ArrayList var2 = new ArrayList();
        var2.add(new StructureVillagePieceWeightDune(ComponentVillageDuneHouse4_Garden.class, 6, 5));
        var2.add(new StructureVillagePieceWeightDune(ComponentVillageDuneChurch.class, 20, 2));
        var2.add(new StructureVillagePieceWeightDune(ComponentVillageDuneHouse1.class, 20, 20));
        var2.add(new StructureVillagePieceWeightDune(ComponentVillageDuneWoodHut.class, 3, 20));
        var2.add(new StructureVillagePieceWeightDune(ComponentVillageDuneHall.class, 15, 5));
        var2.add(new StructureVillagePieceWeightDune(ComponentVillageDuneField.class, 3, 0));
        var2.add(new StructureVillagePieceWeightDune(ComponentVillageDuneField2.class, 3, 0));
        var2.add(new StructureVillagePieceWeightDune(ComponentVillageDuneHouse2.class, 15, 20));
        var2.add(new StructureVillagePieceWeightDune(ComponentVillageDuneHouse3.class, 8, 20));
        Iterator var3 = var2.iterator();

        while (var3.hasNext())
        {
            if (((StructureVillagePieceWeightDune)var3.next()).villagePiecesLimit == 0)
            {
                var3.remove();
            }
        }

        return var2;
    }

    private static int func_75079_a(List par0List)
    {
        boolean var1 = false;
        int var2 = 0;
        StructureVillagePieceWeightDune var4;

        for (Iterator var3 = par0List.iterator(); var3.hasNext(); var2 += var4.villagePieceWeight)
        {
            var4 = (StructureVillagePieceWeightDune)var3.next();

            if (var4.villagePiecesLimit > 0 && var4.villagePiecesSpawned < var4.villagePiecesLimit)
            {
                var1 = true;
            }
        }

        return var1 ? var2 : -1;
    }

    private static ComponentVillageDune func_75083_a(ComponentVillageStartPieceDune par0ComponentVillageStartPieceDune, StructureVillagePieceWeightDune par1StructureVillagePieceWeightDune, List par2List, Random par3Random, int par4, int par5, int par6, int par7, int par8)
    {
        Class var9 = par1StructureVillagePieceWeightDune.villagePieceClassDune;
        Object var10 = null;

        if (var9 == ComponentVillageDuneHouse4_Garden.class)
        {
            var10 = ComponentVillageDuneHouse4_Garden.func_74912_a(par0ComponentVillageStartPieceDune, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == ComponentVillageDuneChurch.class)
        {
            var10 = ComponentVillageDuneChurch.func_74919_a(par0ComponentVillageStartPieceDune, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == ComponentVillageDuneHouse1.class)
        {
            var10 = ComponentVillageDuneHouse1.func_74898_a(par0ComponentVillageStartPieceDune, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == ComponentVillageDuneWoodHut.class)
        {
            var10 = ComponentVillageDuneWoodHut.func_74908_a(par0ComponentVillageStartPieceDune, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == ComponentVillageDuneHall.class)
        {
            var10 = ComponentVillageDuneHall.func_74906_a(par0ComponentVillageStartPieceDune, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == ComponentVillageDuneField.class)
        {
            var10 = ComponentVillageDuneField.func_74900_a(par0ComponentVillageStartPieceDune, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == ComponentVillageDuneField2.class)
        {
            var10 = ComponentVillageDuneField2.func_74902_a(par0ComponentVillageStartPieceDune, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == ComponentVillageDuneHouse2.class)
        {
            var10 = ComponentVillageDuneHouse2.func_74915_a(par0ComponentVillageStartPieceDune, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == ComponentVillageDuneHouse3.class)
        {
            var10 = ComponentVillageDuneHouse3.func_74921_a(par0ComponentVillageStartPieceDune, par2List, par3Random, par4, par5, par6, par7, par8);
        }

        return (ComponentVillageDune)var10;
    }

    /**
     * attempts to find a next Village Component to be spawned
     */
    private static ComponentVillageDune getNextVillageComponent(ComponentVillageStartPieceDune par0ComponentVillageStartPieceDune, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        int var8 = func_75079_a(par0ComponentVillageStartPieceDune.structureVillageWeightedPieceListDune);

        if (var8 <= 0)
        {
            return null;
        }
        else
        {
            int var9 = 0;

            while (var9 < 5)
            {
                ++var9;
                int var10 = par2Random.nextInt(var8);
                Iterator var11 = par0ComponentVillageStartPieceDune.structureVillageWeightedPieceListDune.iterator();

                while (var11.hasNext())
                {
                    StructureVillagePieceWeightDune var12 = (StructureVillagePieceWeightDune)var11.next();
                    var10 -= var12.villagePieceWeight;

                    if (var10 < 0)
                    {
                        if (!var12.canSpawnMoreVillagePiecesOfType(par7) || var12 == par0ComponentVillageStartPieceDune.structVillagePieceWeightDune && par0ComponentVillageStartPieceDune.structureVillageWeightedPieceListDune.size() > 1)
                        {
                            break;
                        }

                        ComponentVillageDune var13 = func_75083_a(par0ComponentVillageStartPieceDune, var12, par1List, par2Random, par3, par4, par5, par6, par7);

                        if (var13 != null)
                        {
                            ++var12.villagePiecesSpawned;
                            par0ComponentVillageStartPieceDune.structVillagePieceWeightDune = var12;

                            if (!var12.canSpawnMoreVillagePieces())
                            {
                                par0ComponentVillageStartPieceDune.structureVillageWeightedPieceListDune.remove(var12);
                            }

                            return var13;
                        }
                    }
                }
            }

            StructureBoundingBox var14 = ComponentVillageDuneTorch.func_74904_a(par0ComponentVillageStartPieceDune, par1List, par2Random, par3, par4, par5, par6);

            if (var14 != null)
            {
                return new ComponentVillageDuneTorch(par0ComponentVillageStartPieceDune, par7, par2Random, var14, par6);
            }
            else
            {
                return null;
            }
        }
    }

    /**
     * attempts to find a next Structure Component to be spawned, private Village function
     */
    private static StructureComponent getNextVillageStructureComponent(ComponentVillageStartPieceDune par0ComponentVillageStartPieceDune, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        if (par7 > 50)
        {
            return null;
        }
        else if (Math.abs(par3 - par0ComponentVillageStartPieceDune.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPieceDune.getBoundingBox().minZ) <= 112)
        {
            ComponentVillageDune var8 = getNextVillageComponent(par0ComponentVillageStartPieceDune, par1List, par2Random, par3, par4, par5, par6, par7 + 1);

            if (var8 != null)
            {
                int var9 = (var8.boundingBox.minX + var8.boundingBox.maxX) / 2;
                int var10 = (var8.boundingBox.minZ + var8.boundingBox.maxZ) / 2;
                int var11 = var8.boundingBox.maxX - var8.boundingBox.minX;
                int var12 = var8.boundingBox.maxZ - var8.boundingBox.minZ;
                int var13 = var11 > var12 ? var11 : var12;

                if (par0ComponentVillageStartPieceDune.getWorldChunkManager().areBiomesViable(var9, var10, var13 / 2 + 4, MapAlwaysGenVillage.villageSpawnBiomes))
                {
                    par1List.add(var8);
                    par0ComponentVillageStartPieceDune.field_74932_i.add(var8);
                    return var8;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    private static StructureComponent getNextComponentVillageDunePath(ComponentVillageStartPieceDune par0ComponentVillageStartPieceDune, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        if (par7 > 3 + par0ComponentVillageStartPieceDune.terrainType)
        {
            return null;
        }
        else if (Math.abs(par3 - par0ComponentVillageStartPieceDune.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPieceDune.getBoundingBox().minZ) <= 112)
        {
            StructureBoundingBox var8 = ComponentVillagePathGenDune.func_74933_a(par0ComponentVillageStartPieceDune, par1List, par2Random, par3, par4, par5, par6);

            if (var8 != null && var8.minY > 10)
            {
                ComponentVillagePathGenDune var9 = new ComponentVillagePathGenDune(par0ComponentVillageStartPieceDune, par7, par2Random, var8, par6);
                int var10 = (var9.boundingBox.minX + var9.boundingBox.maxX) / 2;
                int var11 = (var9.boundingBox.minZ + var9.boundingBox.maxZ) / 2;
                int var12 = var9.boundingBox.maxX - var9.boundingBox.minX;
                int var13 = var9.boundingBox.maxZ - var9.boundingBox.minZ;
                int var14 = var12 > var13 ? var12 : var13;

                if (par0ComponentVillageStartPieceDune.getWorldChunkManager().areBiomesViable(var10, var11, var14 / 2 + 4, MapAlwaysGenVillage.villageSpawnBiomes))
                {
                    par1List.add(var9);
                    par0ComponentVillageStartPieceDune.field_74930_j.add(var9);
                    return var9;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    /**
     * attempts to find a next Structure Component to be spawned
     */
    static StructureComponent getNextStructureComponent(ComponentVillageStartPieceDune par0ComponentVillageStartPieceDune, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        return getNextVillageStructureComponent(par0ComponentVillageStartPieceDune, par1List, par2Random, par3, par4, par5, par6, par7);
    }

    static StructureComponent getNextStructureComponentVillagePath(ComponentVillageStartPieceDune par0ComponentVillageStartPieceDune, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        return getNextComponentVillageDunePath(par0ComponentVillageStartPieceDune, par1List, par2Random, par3, par4, par5, par6, par7);
    }
}
