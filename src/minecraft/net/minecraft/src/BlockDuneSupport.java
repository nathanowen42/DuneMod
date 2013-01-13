package net.minecraft.src;
import java.util.Random;
import java.util.logging.Level;
public class BlockDuneSupport extends BlockContainer
{
	protected BlockDuneSupport(int par1) {
		super(par1, Material.iron);
	}
	
	public TileEntity getBlockEntity()
    {
            try{
                    return (TileEntity)TileEntityDuneSupport.class.newInstance();
            }
            catch(Exception exception){
                    throw new RuntimeException(exception);
            }
    }
	
	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityDuneSupport();
	}
	
	public int idDropped(int i, Random random, int j)
    {
        return mod_DuneMod.itemDuneSupport.itemID;
    }
    
    public int quanityDropped(Random random){
    	  return 1;
    	 }
    
    public int getRenderType(){
		return -1;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
    	this.setBlockBounds(0.0F, 1F, 0.0F, 1.0F, 0.80F, 1.0F);
        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }
    
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
    	this.setBlockBounds(0.0F, 1F, 0.0F, 1.0F, 0.80F, 1.0F);
        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
    }
    
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {

        if (par1World.isBlockNormalCubeDefault(par2 - 1, par3, par4, true) ? true : (par1World.isBlockNormalCubeDefault(par2 + 1, par3, par4, true) ? true : (par1World.isBlockNormalCubeDefault(par2, par3, par4 - 1, true) ? true : (par1World.isBlockNormalCubeDefault(par2, par3, par4 + 1, true)))) && par1World.isBlockNormalCubeDefault(par2, par3 + 1, par4, true))
    		return true;
//    	else if ((par1World.getBlockTileEntity(par2, par3, par4 - 1) instanceof TileEntityDuneSupport ? true : false) ||
//    			(par1World.getBlockTileEntity(par2, par3, par4 + 1) instanceof TileEntityDuneSupport ? true : false) ||
//    			(par1World.getBlockTileEntity(par2 - 1, par3, par4) instanceof TileEntityDuneSupport ? true : false) ||
//    			(par1World.getBlockTileEntity(par2 + 1, par3, par4) instanceof TileEntityDuneSupport ? true : false))
//    		return true;
    	else
    		return par1World.isBlockNormalCubeDefault(par2 - 1, par3, par4, true) ? true : (par1World.isBlockNormalCubeDefault(par2 + 1, par3, par4, true) ? true : (par1World.isBlockNormalCubeDefault(par2, par3, par4 - 1, true) ? true : (par1World.isBlockNormalCubeDefault(par2, par3, par4 + 1, true))));
    }
    
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        int var10 = par9;
        
        if (par5 == 1 && par1World.isBlockNormalCubeDefault(par2, par3 - 1, par4, true))
        {
        	if (par1World.isBlockNormalCubeDefault(par2, par3, par4 + 1, true))
            {
                var10 = 4;
            }else if (par1World.isBlockNormalCubeDefault(par2, par3, par4 - 1, true))
            {
                var10 = 3;
            }else if (par1World.isBlockNormalCubeDefault(par2 + 1, par3, par4, true))
            {
                var10 = 2;
            }else if (par1World.isBlockNormalCubeDefault(par2 - 1, par3, par4, true))
            {
                var10 = 1;
            }
        }
        
        if (par5 == 2 && par1World.isBlockNormalCubeDefault(par2, par3, par4 + 1, true))
        {
            var10 = 4;
        }

        if (par5 == 3 && par1World.isBlockNormalCubeDefault(par2, par3, par4 - 1, true))
        {
            var10 = 3;
        }

        if (par5 == 4 && par1World.isBlockNormalCubeDefault(par2 + 1, par3, par4, true))
        {
            var10 = 2;
        }

        if (par5 == 5 && par1World.isBlockNormalCubeDefault(par2 - 1, par3, par4, true))
        {
            var10 = 1;
        }
        
        if (par5 == 6 && par1World.isBlockNormalCubeDefault(par2, par3 + 1, par4, true))
        {
        	if (par1World.isBlockNormalCubeDefault(par2, par3, par4 + 1, true))
            {
                var10 = 4;
            }

            if (par1World.isBlockNormalCubeDefault(par2, par3, par4 - 1, true))
            {
                var10 = 3;
            }

            if (par1World.isBlockNormalCubeDefault(par2 + 1, par3, par4, true))
            {
                var10 = 2;
            }

            if (par1World.isBlockNormalCubeDefault(par2 - 1, par3, par4, true))
            {
                var10 = 1;
            }
        }
        
//        if ((par1World.getBlockTileEntity(par2, par3, par4 - 1) instanceof TileEntityDuneSupport ? true : false) ||
//    		(par1World.getBlockTileEntity(par2, par3, par4 + 1) instanceof TileEntityDuneSupport ? true : false) ||
//    		(par1World.getBlockTileEntity(par2 - 1, par3, par4) instanceof TileEntityDuneSupport ? true : false) ||
//    		(par1World.getBlockTileEntity(par2 + 1, par3, par4) instanceof TileEntityDuneSupport ? true : false))
//        	var10 = 5;

        ModLoader.getLogger().log(Level.INFO, "set meta " + var10);

        return var10;
    }
}
