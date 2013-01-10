package net.minecraft.src;

import java.util.Random;

public class DuneWorldGenVillage {

	public DuneWorldGenVillage() {
	}

	private MapAlwaysGenVillage villageGenerator;
	byte abyte0[] = new byte[32768];
	Random rand = new Random();

	public IChunkProvider getChunkGenerator(World world) {
		return new DuneChunkProvider(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled());
	}

	// public World worldObj;

	public boolean generate(World par1World, Random par2Random, int xStart, int yStart, int zStart) {
		BiomeGenBase biome = par1World.getWorldChunkManager().getBiomeGenAt(xStart, yStart);
		if (!(biome instanceof BiomeGenDune)) {
			return false;
		}
		int par1 = xStart/16;
		int par2 = yStart/16;
		villageGenerator = new MapAlwaysGenVillage(0);
		villageGenerator.generate(getChunkGenerator(par1World), par1World, par1, par2, abyte0);
		Boolean flag = villageGenerator.generateStructuresInChunk(par1World, rand, par1, par2);
		return true;
	}

}
