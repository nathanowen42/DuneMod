package net.minecraft.src;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;

public class GuiBinoculars extends Gui
{
    public void Draw(Minecraft mc)
    {
    	ScaledResolution var5 = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
        int var6 = var5.getScaledWidth();
        int var7 = var5.getScaledHeight();
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, mc.renderEngine.getTexture("/gui/binocularsblur.png"));
        Tessellator var3 = Tessellator.instance;
        var3.startDrawingQuads();
        var3.addVertexWithUV(0.0D, (double)var7, -90.0D, 0.0D, 1.0D);
        var3.addVertexWithUV((double)var6, (double)var7, -90.0D, 1.0D, 1.0D);
        var3.addVertexWithUV((double)var6, 0.0D, -90.0D, 1.0D, 0.0D);
        var3.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
        var3.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
