package net.minecraft.src;

public class StructureVillagePieceWeightDune
{
    /** The Class object for the represantation of this village piece. */
    public Class villagePieceClassDune;
    public final int villagePieceWeight;
    public int villagePiecesSpawned;
    public int villagePiecesLimit;

    public StructureVillagePieceWeightDune(Class par1Class, int par2, int par3)
    {
        this.villagePieceClassDune = par1Class;
        this.villagePieceWeight = par2;
        this.villagePiecesLimit = par3;
    }

    public boolean canSpawnMoreVillagePiecesOfType(int par1)
    {
        return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
    }

    public boolean canSpawnMoreVillagePieces()
    {
        return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
    }
}
