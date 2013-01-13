package net.minecraft.src;

public class ModelDuneSupport extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
  
  public ModelDuneSupport()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 17, 0);
      Shape1.addBox(0F, 0F, 0F, 1, 14, 1);
      Shape1.setRotationPoint(7F, 9F, 7F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 5, 0);
      Shape2.addBox(0F, 0F, 0F, 1, 14, 1);
      Shape2.setRotationPoint(-8F, 9F, 7F);
      Shape2.setTextureSize(64, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 10, 0);
      Shape3.addBox(0F, 0F, 0F, 2, 14, 1);
      Shape3.setRotationPoint(-1F, 9F, 7F);
      Shape3.setTextureSize(64, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(0F, 0F, 0F, 1, 16, 1);
      Shape4.setRotationPoint(-8F, 24F, 7F);
      Shape4.setTextureSize(64, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, -1.570796F);
      Shape5 = new ModelRenderer(this, 45, 0);
      Shape5.addBox(0F, 0F, 0F, 1, 16, 1);
      Shape5.setRotationPoint(7F, 9F, -1.8F);
      Shape5.setTextureSize(64, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0.5948578F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 30, 0);
      Shape6.addBox(0F, 0F, 0F, 1, 16, 1);
      Shape6.setRotationPoint(-8F, 9F, -1.8F);
      Shape6.setTextureSize(64, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0.5948578F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 40, 0);
      Shape7.addBox(0F, 0F, 0F, 1, 16, 1);
      Shape7.setRotationPoint(0F, 9F, -1.8F);
      Shape7.setTextureSize(64, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0.5948578F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 35, 0);
      Shape8.addBox(0F, 0F, 0F, 1, 16, 1);
      Shape8.setRotationPoint(-1F, 9F, -1.8F);
      Shape8.setTextureSize(64, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0.5948578F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 21);
      Shape9.addBox(0F, 0F, 0F, 16, 1, 16);
      Shape9.setRotationPoint(-8F, 8F, -8F);
      Shape9.setTextureSize(64, 64);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(entity, f, f1, f2, f3, f4, f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
  }
  
  public void renderModel(float f1)
  {
	  Shape2.render(f1);
	  Shape1.render(f1);
	  Shape3.render(f1);
	  Shape4.render(f1);
	  Shape5.render(f1);
	  Shape6.render(f1);
	  Shape7.render(f1);
	  Shape8.render(f1);
	  Shape9.render(f1);
  }
  
  public void renderModelTop(float f1)
  {
	  Shape9.render(f1);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
