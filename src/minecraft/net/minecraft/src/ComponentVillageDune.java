package net.minecraft.src;

import java.util.List;
import java.util.Random;

abstract class ComponentVillageDune extends StructureComponent
{
    /** The number of villagers that have been spawned in this component. */
    private int villagersSpawned;
    protected ComponentVillageStartPieceDune field_74897_k;

    protected ComponentVillageDune(ComponentVillageStartPieceDune par1ComponentVillageStartPieceDune, int par2)
    {
        super(par2);
        this.field_74897_k = par1ComponentVillageStartPieceDune;
    }

    /**
     * Gets the next village component, with the bounding box shifted -1 in the X and Z direction.
     */
    protected StructureComponent getNextComponentNN(ComponentVillageStartPieceDune par1ComponentVillageStartPieceDune, List par2List, Random par3Random, int par4, int par5)
    {
        switch (this.coordBaseMode)
        {
            case 0:
                return StructureVillagePiecesDune.getNextStructureComponent(par1ComponentVillageStartPieceDune, par2List, par3Random, this.boundingBox.minX - 1, this.boundingBox.minY + par4, this.boundingBox.minZ + par5, 1, this.getComponentType());

            case 1:
                return StructureVillagePiecesDune.getNextStructureComponent(par1ComponentVillageStartPieceDune, par2List, par3Random, this.boundingBox.minX + par5, this.boundingBox.minY + par4, this.boundingBox.minZ - 1, 2, this.getComponentType());

            case 2:
                return StructureVillagePiecesDune.getNextStructureComponent(par1ComponentVillageStartPieceDune, par2List, par3Random, this.boundingBox.minX - 1, this.boundingBox.minY + par4, this.boundingBox.minZ + par5, 1, this.getComponentType());

            case 3:
                return StructureVillagePiecesDune.getNextStructureComponent(par1ComponentVillageStartPieceDune, par2List, par3Random, this.boundingBox.minX + par5, this.boundingBox.minY + par4, this.boundingBox.minZ - 1, 2, this.getComponentType());

            default:
                return null;
        }
    }

    /**
     * Gets the next village component, with the bounding box shifted +1 in the X and Z direction.
     */
    protected StructureComponent getNextComponentPP(ComponentVillageStartPieceDune par1ComponentVillageStartPieceDune, List par2List, Random par3Random, int par4, int par5)
    {
        switch (this.coordBaseMode)
        {
            case 0:
                return StructureVillagePiecesDune.getNextStructureComponent(par1ComponentVillageStartPieceDune, par2List, par3Random, this.boundingBox.maxX + 1, this.boundingBox.minY + par4, this.boundingBox.minZ + par5, 3, this.getComponentType());

            case 1:
                return StructureVillagePiecesDune.getNextStructureComponent(par1ComponentVillageStartPieceDune, par2List, par3Random, this.boundingBox.minX + par5, this.boundingBox.minY + par4, this.boundingBox.maxZ + 1, 0, this.getComponentType());

            case 2:
                return StructureVillagePiecesDune.getNextStructureComponent(par1ComponentVillageStartPieceDune, par2List, par3Random, this.boundingBox.maxX + 1, this.boundingBox.minY + par4, this.boundingBox.minZ + par5, 3, this.getComponentType());

            case 3:
                return StructureVillagePiecesDune.getNextStructureComponent(par1ComponentVillageStartPieceDune, par2List, par3Random, this.boundingBox.minX + par5, this.boundingBox.minY + par4, this.boundingBox.maxZ + 1, 0, this.getComponentType());

            default:
                return null;
        }
    }

    /**
     * Discover the y coordinate that will serve as the ground level of the supplied BoundingBox. (A median of all the
     * levels in the BB's horizontal rectangle).
     */
    protected int getAverageGroundLevel(World par1World, StructureBoundingBox par2StructureBoundingBox)
    {
        int var3 = 0;
        int var4 = 0;

        for (int var5 = this.boundingBox.minZ; var5 <= this.boundingBox.maxZ; ++var5)
        {
            for (int var6 = this.boundingBox.minX; var6 <= this.boundingBox.maxX; ++var6)
            {
                if (par2StructureBoundingBox.isVecInside(var6, 64, var5))
                {
                    var3 += Math.max(par1World.getTopSolidOrLiquidBlock(var6, var5), par1World.provider.getAverageGroundLevel());
                    ++var4;
                }
            }
        }

        if (var4 == 0)
        {
            return -1;
        }
        else
        {
            return var3 / var4;
        }
    }

    protected static boolean canVillageGoDeeper(StructureBoundingBox par0StructureBoundingBox)
    {
        return par0StructureBoundingBox != null && par0StructureBoundingBox.minY > 10;
    }

    /**
     * Spawns a number of villagers in this component. Parameters: world, component bounding box, x offset, y offset, z
     * offset, number of villagers
     */
    protected void spawnVillagers(World par1World, StructureBoundingBox par2StructureBoundingBox, int par3, int par4, int par5, int par6)
    {
        if (this.villagersSpawned < par6)
        {
            for (int var7 = this.villagersSpawned; var7 < par6; ++var7)
            {
                int var8 = this.getXWithOffset(par3 + var7, par5);
                int var9 = this.getYWithOffset(par4);
                int var10 = this.getZWithOffset(par3 + var7, par5);

                if (!par2StructureBoundingBox.isVecInside(var8, var9, var10))
                {
                    break;
                }

                ++this.villagersSpawned;
                EntityVillager var11 = new EntityVillager(par1World, this.getVillagerType(var7));
                var11.setLocationAndAngles((double)var8 + 0.5D, (double)var9, (double)var10 + 0.5D, 0.0F, 0.0F);
                par1World.spawnEntityInWorld(var11);
            }
        }
    }

    /**
     * Returns the villager type to spawn in this component, based on the number of villagers already spawned.
     */
    protected int getVillagerType(int par1)
    {
        return 0;
    }

    protected int func_74890_d(int par1, int par2)
    {
        if (this.field_74897_k.field_74927_b)
        {
        	if (par1 == Block.wood.blockID)
            {
                return Block.netherBrick.blockID;
            }

            if (par1 == Block.cobblestone.blockID)
            {
                return Block.netherBrick.blockID;
            }

            if (par1 == Block.planks.blockID)
            {
                return Block.netherBrick.blockID;
            }

            if (par1 == Block.stairCompactPlanks.blockID)
            {
                return Block.stairsNetherBrick.blockID;
            }

            if (par1 == Block.stairCompactCobblestone.blockID)
            {
                return Block.stairsNetherBrick.blockID;
            }

            if (par1 == Block.gravel.blockID)
            {
                return Block.netherBrick.blockID;
            }
            if (par1 == Block.waterMoving.blockID)
            {
                return Block.sand.blockID;
            }
            if (par1 == Block.fence.blockID)
            {
                return Block.netherFence.blockID;
            }
            if (par1 == Block.dirt.blockID)
            {
                return Block.netherBrick.blockID;
            }
        }

        return par1;
    }

    protected int func_74892_e(int par1, int par2)
    {
        if (this.field_74897_k.field_74927_b)
        {
            if (par1 == Block.wood.blockID)
            {
                return 0;
            }

            if (par1 == Block.cobblestone.blockID)
            {
                return 0;
            }

            if (par1 == Block.planks.blockID)
            {
                return 2;
            }
        }

        return par2;
    }

    /**
     * current Position depends on currently set Coordinates mode, is computed here
     */
    protected void placeBlockAtCurrentPosition(World par1World, int par2, int par3, int par4, int par5, int par6, StructureBoundingBox par7StructureBoundingBox)
    {
        int var8 = this.func_74890_d(par2, par3);
        int var9 = this.func_74892_e(par2, par3);
        super.placeBlockAtCurrentPosition(par1World, var8, var9, par4, par5, par6, par7StructureBoundingBox);
    }

    /**
     * arguments: (World worldObj, StructureBoundingBox structBB, int minX, int minY, int minZ, int maxX, int maxY, int
     * maxZ, int placeBlockId, int replaceBlockId, boolean alwaysreplace)
     */
    protected void fillWithBlocks(World par1World, StructureBoundingBox par2StructureBoundingBox, int par3, int par4, int par5, int par6, int par7, int par8, int par9, int par10, boolean par11)
    {
        int var12 = this.func_74890_d(par9, 0);
        int var13 = this.func_74892_e(par9, 0);
        int var14 = this.func_74890_d(par10, 0);
        int var15 = this.func_74892_e(par10, 0);
        super.fillWithMetadataBlocks(par1World, par2StructureBoundingBox, par3, par4, par5, par6, par7, par8, var12, var13, var14, var15, par11);
    }

    /**
     * Overwrites air and liquids from selected position downwards, stops at hitting anything else.
     */
    protected void fillCurrentPositionBlocksDownwards(World par1World, int par2, int par3, int par4, int par5, int par6, StructureBoundingBox par7StructureBoundingBox)
    {
        int var8 = this.func_74890_d(par2, par3);
        int var9 = this.func_74892_e(par2, par3);
        super.fillCurrentPositionBlocksDownwards(par1World, var8, var9, par4, par5, par6, par7StructureBoundingBox);
    }
}
