package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class ItemBinoculars extends Item {
	Map map = new HashMap();
	
	protected ItemBinoculars(int par1) {
		super(par1);
        this.maxStackSize = 1;
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		Class clazz = EntityRenderer.class;
		Object instance = ModLoader.getMinecraftInstance().entityRenderer;
		int field = 36;

		try {
			double newValue = 10.0;
			ModLoader.setPrivateValue(clazz, instance, field, newValue);
		} catch (Exception ex) {
			ModLoader.getLogger().log(Level.INFO, "zoom failed " + ex.getMessage());
		}
        return par1ItemStack;
    }
	
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
	{
		Class clazz = EntityRenderer.class;
		Object instance = ModLoader.getMinecraftInstance().entityRenderer;
		int field = 36;

		try {
			double newValue = 1.0;
			ModLoader.setPrivateValue(clazz, instance, field, newValue);
		} catch (Exception ex) {
			ModLoader.getLogger().log(Level.INFO, "zoom failed " + ex.getMessage());
		}
	}
	
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return -1;
    }

    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.none;
    }
}
