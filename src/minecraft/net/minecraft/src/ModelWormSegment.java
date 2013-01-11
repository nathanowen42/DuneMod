package net.minecraft.src;

public class ModelWormSegment extends ModelBase
{
  //fields
    ModelRenderer WormSegment;
  
  public ModelWormSegment()
  {
    textureWidth = 512;
    textureHeight = 512;
    
      WormSegment = new ModelRenderer(this, 0, 0);
      WormSegment.addBox(-120F, -120F, -16F, 240, 240, 16);
      WormSegment.setRotationPoint(0F, -96F, 8F);
      WormSegment.setTextureSize(512, 512);
      WormSegment.mirror = true;
      setRotation(WormSegment, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    WormSegment.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}

