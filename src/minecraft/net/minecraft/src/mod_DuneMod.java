package net.minecraft.src;
import java.util.Random;

import net.minecraft.client.Minecraft;

public class mod_DuneMod extends BaseMod
{
    public static DuneWorldType DuneWorldType = new DuneWorldType(); // Create a new copy of our World Type
    public static final BiomeGenBase dune = (new BiomeGenDune(23)).setColor(0xfa9418).setBiomeName("dune");

    public static final Block blockStaticSand = new BlockStaticSand(200, Material.sand);
    public static final Block blockDuneSupport = new BlockDuneSupport(201).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep);
    	
    public static final Item itemStaticProbe = new ItemStaticProbe(5000).setItemName("Static Probe");
    public static final Item itemBinoculars = new ItemBinoculars(5001).setItemName("Binoculars");
    public static final Item itemDuneSupport = new ItemReed(5002, blockDuneSupport).setItemName("Dune Support");
    
	GuiBinoculars guiBin = new GuiBinoculars();
    public static boolean drawBinocularHUD = false;
	
    public mod_DuneMod()
    { 
    }

    private MapAlwaysGenVillage villageGenerator;

    public String getVersion()
    {
        return "DuneCraft 0.24 for Minecraft 1.3.1";
    }

    public void load()
    {
        ModLoader.addLocalization("generator.void", "Dune"); // Add dune world generator
        
        ModLoader.addName(itemStaticProbe, "Static Probe"); // Add static probe name
        itemStaticProbe.setCreativeTab(CreativeTabs.tabTools); // Add static probe to creative menu
        
        ModLoader.registerBlock(blockStaticSand); // register static sand
        ModLoader.addName(blockStaticSand, "Static Sand"); // add static block name
        blockStaticSand.setCreativeTab(CreativeTabs.tabBlock); // add static block to creative menu
        
        ModLoader.setInGameHook(this, true, false);
        
        ModLoader.addName(itemBinoculars, "Binoculars"); // Add static probe name
        itemBinoculars.setCreativeTab(CreativeTabs.tabTools); // Add static probe to creative menu
        
        RenderDuneSupport render = new RenderDuneSupport();
		
        ModLoader.registerBlock(blockDuneSupport);
		ModLoader.registerTileEntity(TileEntityDuneSupport.class, "TileEntityDuneSupport", render);

		ModLoader.addName(itemDuneSupport, "Dune Supports");
		itemDuneSupport.setCreativeTab(CreativeTabs.tabMisc);
        
    }
    public void generateSurface(World world, Random rand, int i, int j)
    {
        int test = rand.nextInt(100);

        if (i % 6000 < 130 && j % 6000 < 130)
        {
            (new DuneWorldGenFlattener()).generate(world, rand, i + 8, j + 8, 100);
            (new DuneWorldGenSheildWall()).generate(world, rand, i - 8, j - 8, 100);
            (new DuneWorldGenVillage()).generate(world, rand, i, j, 100);
        }
        else if ((i % 128 == 0 && j % 256 == 0) && test < 40)
        {
            int RandPosX = i + rand.nextInt(256);
            int RandPosY = j + rand.nextInt(256);
            int RandPosZ = 100;

            if (RandPosX % 6000 > 140 && RandPosX % 6000 > 140)
            {
                (new DuneWorldGenOutcroppings()).generate(world, rand, RandPosX, RandPosY, RandPosZ);
            }
        }
    }
    
    public boolean onTickInGame(float f, Minecraft minecraft)
    {
    	if (drawBinocularHUD)
			guiBin.Draw(ModLoader.getMinecraftInstance());
    	return true;
    }
}


//weird changed files list: BiomeDecorator, WorldProvider, WorldType,
