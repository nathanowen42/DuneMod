package net.minecraft.src;


public class RidgedMultifractalNoiseSin {
	public static double Noise2D(float x, float z,  int NumberOfOctaves, float frequency, float amplitude, float hScale, float vScale, float offset, int seed)
    {
        double offset1 = RidgedMultifractalNoise.AddRidgedMultifractalNoise2D(x, z, NumberOfOctaves, frequency, amplitude, hScale, vScale, offset, seed);
        double y = Math.abs(Math.sin((x + offset1 * 2)/10))-2;
        return y;
    }

    public static double RidgedMultifractalNoiseSinNoise2D(float x, float z, int NumberOfOctaves, float frequency, float amplitude, float hScale, float vScale, float offset, int seed)
    {
        double n = SmoothNoise2D(x, z,  NumberOfOctaves, frequency, amplitude, hScale, vScale, offset, seed);
        return n;
    }

    public static double SmoothNoise2D(float x, float z,  int NumberOfOctaves, float frequency, float amplitude, float hScale, float vScale, float offset, int seed)
    {
        double corners = (Noise2D(x - 1, z - 1,  NumberOfOctaves, frequency, amplitude, hScale, vScale, offset, seed) + Noise2D(x + 1, z - 1,  NumberOfOctaves, frequency, amplitude, hScale, vScale, offset, seed) + Noise2D(x - 1, z + 1,  NumberOfOctaves, frequency, amplitude, hScale, vScale, offset, seed) + Noise2D(x + 1, z + 1,  NumberOfOctaves, frequency, amplitude, hScale, vScale, offset, seed)) / 16;
        double sides = (Noise2D(x - 1, z,  NumberOfOctaves, frequency, amplitude, hScale, vScale, offset, seed) + Noise2D(x + 1, z,  NumberOfOctaves, frequency, amplitude, hScale, vScale, offset, seed) + Noise2D(x, z - 1,  NumberOfOctaves, frequency, amplitude, hScale, vScale, offset, seed) + Noise2D(x, z + 1,  NumberOfOctaves, frequency, amplitude, hScale, vScale, offset, seed)) / 8;
        double center = Noise2D(x, z,  NumberOfOctaves, frequency, amplitude, hScale, vScale, offset, seed) / 4;

        return corners + sides + center;
    }
}
