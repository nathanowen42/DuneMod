package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

public class SandWormEntity extends EntityMob{

	public double targetX;
    public double targetY;
    public double targetZ;
	
    private static int MAX_SEGMENTS = 200;
    int currentSegments = 200;
    SandWormSegment[] body;
    
    
	public SandWormEntity(World par1World) {
		super(par1World);
		this.setEntityHealth(this.getMaxHealth());
		this.texture = "/DuneMod/SandWormHead.png";
		this.setSize(16.0F, 8.0F);
		this.noClip = true;
		this.isImmuneToFire = true;
		this.targetY = 100.0D;
		this.ignoreFrustumCheck = true;
	}

	public int getMaxHealth() {
		return 200000;
	}
	
	protected void spawnBodySegments()
    {
        if (!this.worldObj.isRemote)
        {
            if (this.body == null)
            {
                this.body = new SandWormSegment[MAX_SEGMENTS];
            }

            for (int var1 = 0; var1 < this.currentSegments; ++var1)
            {
                if (this.body[var1] == null || this.body[var1].isDead)
                {
                    this.body[var1] = new SandWormSegment(this.worldObj, this, var1);
                    this.body[var1].setLocationAndAngles(this.posX + 0.1D * (double)var1, this.posY + 0.5D, this.posZ + 0.1D * (double)var1, this.rand.nextFloat() * 360.0F, 0.0F);
                    this.worldObj.spawnEntityInWorld(this.body[var1]);
                }
            }
        }
    }
	
	protected void moveSegments(){
		
		this.spawnBodySegments();

        if (!this.worldObj.isRemote){
        	this.body[currentSegments].moveSegmentTowards(this);
        	for (int var1 = 1; var1 < this.currentSegments; ++var1){
                this.body[var1].moveSegmentTowards(this.body[var1 - 1]);
            }
        }
		
	}
	
    protected void updateEntityActionState(){
        this.despawnEntity();
        EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 120.0D);

        if (var1 != null && shouldAttackPlayer(var1))
        {
            this.faceEntity(var1, 10.0F, 20.0F);
            this.moveForward = 0.1F;
        }

        else{
  
          this.moveStrafing = this.moveForward = 0.0F;

        }
    }
	
	private boolean shouldAttackPlayer(EntityPlayer par1EntityPlayer)
    {
        //if (!(par1EntityPlayer.isSneaking())){
        //    return true;
        //} //only implement this if you want the game to be harder and more irritating lol
        
        if(par1EntityPlayer.isSprinting()){
        	   return true;
        }
        else{
        	return false;
        }
    }
	
	 protected String getLivingSound(){
		 return "mob.sandWorm";
	 }
	 
	 public void writeEntityToNBT(NBTTagCompound nbttagcompound){
		 super.writeEntityToNBT(nbttagcompound);
	 }

	 public void readEntityFromNBT(NBTTagCompound nbttagcompound){
    	super.readEntityFromNBT(nbttagcompound);
	 }
	 
	protected float getSoundVolume(){
		return 8F;
	}
	
}
