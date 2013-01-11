package net.minecraft.src;

public class SandWormSegment extends EntityLiving{

	SandWormEntity head;
    double segmentDist;
    int attackStrength;
    int deathCounter;
	
	public SandWormSegment(World var1)
    {
        super(var1);
        this.segmentDist = 5.5D;
        this.texture = "/DuneMod/SandWormSegment.png";
        this.setSize(1.75F, 1.95F);
        this.stepHeight = 2.0F;
        this.health = 1000;
        this.isImmuneToFire = true;
        this.attackStrength = 3;
    }
	
	public SandWormSegment(World var1, double var2, double var4, double var6)
    {
        this(var1);
        this.setPosition(var2, var4, var6);
    }

    public SandWormSegment(World var1, SandWormEntity var2, int var3)
    {
        this(var1);
        this.head = var2;
        this.setSegment(var3);
        this.moveSpeed = var2.getAIMoveSpeed() * 1.5F;
        this.landMovementFactor = var2.landMovementFactor;
        this.jumpMovementFactor = var2.jumpMovementFactor;
    }
    
    public void moveSegmentTowards(Entity var1)
    {
    	this.moveSpeed = this.head.getAIMoveSpeed();
        this.setPositionAndRotation(var1.posX, var1.posY, var1.posZ, var1.rotationYaw, var1.rotationPitch);
    }

    public void setSegment(int var1)
    {
        this.dataWatcher.updateObject(16, new Byte((byte)var1));
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)1));
    }
    
	public int getMaxHealth() {
		return 1000;
	}

}
