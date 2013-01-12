package net.minecraft.src;

public class ItemStaticProbe extends Item
{
    protected ItemStaticProbe(int par1)
    {
        super(par1);
        this.maxStackSize = 1;
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par3World.getBlockId(par4, par5, par6) == Block.sand.blockID)
        {
            par3World.setBlock(par4, par5, par6, mod_DuneMod.blockStaticSand.blockID);
            return true;
        }

        return false;
    }
}
