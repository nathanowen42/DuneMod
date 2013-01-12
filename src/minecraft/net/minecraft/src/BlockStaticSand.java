package net.minecraft.src;

import java.util.Random;

public class BlockStaticSand extends Block
{
    protected BlockStaticSand(int par1, Material sand)
    {
        super(par1, Material.sand);
        this.setCreativeTab(CreativeTabs.tabBlock);
        setHardness(0.5F);
        setStepSound(soundSandFootstep);
        setBlockName("Static Sand");
        this.blockIndexInTexture = Block.sand.blockIndexInTexture;
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        int meta = par1World.getBlockMetadata(par2, par3, par4);

        if (meta <= 0)
        {
            par1World.setBlock(par2, par3, par4, Block.sand.blockID);
            par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
        }
        else
        {
            par1World.setBlockMetadata(par2, par3, par4, meta - 1);
        }
    }

    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        par1World.setBlockMetadata(par2, par3, par4, 1);
    }
}
