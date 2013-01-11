package net.minecraft.src;

public class RenderWormSegment extends RenderLiving
{
    public RenderWormSegment(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    public void renderWormSegment(SandWormEntity par1SandWormIntity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1SandWormIntity, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderWormSegment((SandWormEntity)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderWormSegment((SandWormEntity)par1Entity, par2, par4, par6, par8, par9);
    }
}