package net.minecraft.src;

import java.util.*;

public class DuneChunkManager extends WorldChunkManager {
private List biomesToSpawnIn;

public DuneChunkManager() {
        biomesToSpawnIn = new ArrayList();
        biomesToSpawnIn.add(BiomeGenBase.dune); // Which biomes can you spawn in?
}

public DuneChunkManager(World world) {
        this();
        // Just to keep the original constructor from being called, save the
        // world value if you need it later.
}

// Gets the list of valid biomes for the player to spawn in.
public List getBiomesToSpawnIn() {
        return biomesToSpawnIn;
}

private BiomeGenBase activeBiome(int i, int j) {
        return BiomeGenDune.dune;
        // You can set the biome based on the X(i) and Z(j) location, here I am just
        // setting the whole world to desert biome.
}

// Returns the BiomeGenBase related to the x, z position on the world.
public BiomeGenBase getBiomeGenAt(int i, int j) {
        return activeBiome(i, j);
        // Same as the above method, there is a lot of this in the Minecraft code.
}

// Returns a list of rainfall values for the specified blocks. Args: listToReuse, x, z, width, length.
// Ours will set the rainfall to 0 everywhere.
public float[] getRainfall(float par1ArrayOfFloat[], int par2, int par3, int par4, int par5) {
        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
         par1ArrayOfFloat = new float[par4 * par5];
        }
        Arrays.fill(par1ArrayOfFloat, 0, par4 * par5, 0.0F);
        return par1ArrayOfFloat;
}

// Returns a list of temperatures to use for the specified blocks. Args: listToReuse, x, y, width, length
// Ours will set the temp to 0 everywhere.


// Returns an array of biomes for the location input.
// Everywhere is desert...
public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase par1ArrayOfBiomeGenBase[], int par2, int par3, int par4, int par5) {
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
         par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }
        Arrays.fill(par1ArrayOfBiomeGenBase, 0, par4 * par5, BiomeGenBase.dune);
        return par1ArrayOfBiomeGenBase;
}

// Returns biomes to use for the blocks and loads the other data like temperature and humidity onto the WorldChunkManager Args: oldBiomeList, x, z, width, depth
// Everywhere is STILL desert...
public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase par1ArrayOfBiomeGenBase[], int par2, int par3, int par4, int par5) {
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
         par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }
        Arrays.fill(par1ArrayOfBiomeGenBase, 0, par4 * par5, BiomeGenBase.dune);
        return par1ArrayOfBiomeGenBase;
}

// checks given Chunk's Biomes against List of allowed ones
public boolean areBiomesViable(int i, int j, int k, List list) {
        return true; // Since we only used desert, yep they are allowed.
}
public BiomeGenBase[] getBiomeGenAt(BiomeGenBase par1ArrayOfBiomeGenBase[], int par2, int par3, int par4, int par5, boolean par6) {
        return loadBlockGeneratorData(par1ArrayOfBiomeGenBase, par2, par3, par4, par5);
}

// Finds a valid position within a range, that is once of the listed biomes.
public ChunkPosition findBiomePosition(int i, int j, int k, List list, Random random) {
        return new ChunkPosition(0, 0, 0); // Y position ignored, uses sea level for y spawn.
        // This will set your spawn X amd Z location.
}
}
