package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderDuneSupport extends TileEntitySpecialRenderer
{
    private ModelDuneSupport model = new ModelDuneSupport();;
    
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		renderModelAt((TileEntityDuneSupport)var1, var2, var4, var6, var8);
		
	}
 	
    public void renderModelAt(TileEntityDuneSupport tileentity1, double d, double d1, double d2, float f)
    {   
    	int angle = 0;
    	int xangle = 0;
    	int yangle = 0;
    	int zangle = 0;
    	if (tileentity1.getBlockMetadata() == 4)
        {
    		angle = 180;
    		xangle = 0;
    		yangle = 1;
    		zangle = 0;
        }else if (tileentity1.getBlockMetadata() == 3)
        {
        	angle = 0;
    		xangle = 0;
    		yangle = 0;
    		zangle = 0;
        }else if (tileentity1.getBlockMetadata() == 2)
        {
        	angle = 90;
    		xangle = 0;
    		yangle = 1;
    		zangle = 0;
        }else if (tileentity1.getBlockMetadata() == 1)
        {
        	angle = 90;
    		xangle = 0;
    		yangle = -1;
    		zangle = 0;
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5f, (float)d2 + 0.5F);
        GL11.glRotatef(180, 1, 0, 0);
    	GL11.glRotatef(angle, xangle, yangle, zangle);
        bindTextureByName("/Block/DuneSupport.png");
        GL11.glPushMatrix();
        if (tileentity1.getBlockMetadata() == 5)
        	model.renderModelTop(0.0625F);
        else
        	model.renderModel(0.0625F);
        GL11.glPopMatrix();     
        GL11.glPopMatrix();                     
    }

}
