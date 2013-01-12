package net.minecraft.src;

public class DuneWorldType extends WorldType
{
    public DuneWorldType()
    {
        super(5, "Dune");
        // The first parameter is the id number of the WorldType,
        // vanilla Minecraft uses 0, 1, and 8 already. The max that can be used is 15,
        // The second parameter is our textname for our WorldType, the case needs to
        // match the "generator.Dune" localization in the "mod_" file.
    }

    public WorldChunkManager getChunkManager(World world)
    {
        return new DuneChunkManager(world);
        // This is our ChunkManager class, it controls rain, temp, biomes, and spawn location
    }

    public IChunkProvider getChunkGenerator(World world, String flatOptions)
    {
        return new DuneChunkProvider(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled());
        // This is our ChunkProvider, this generates the world.
    }

    public boolean hasVoidParticles(boolean flag)
    {
        return false; // Used to determine if there is a sky
    }

    public int getSeaLevel(World world)
    {
        return 60; // Sets the Sea Level, be careful with this one, it controls the Y value of your spawn point.
    }

    public double voidFadeMagnitude()
    {
        return 5.0D; // Sets the void fade, play with it to see which values work for you.
    }
    /*
    public Vec3 getFogColor(float par1, float par2)
    {
    	return Vec3.func_72437_a().func_72345_a(2.095F, .607F, 1F);
    }
    */
}
