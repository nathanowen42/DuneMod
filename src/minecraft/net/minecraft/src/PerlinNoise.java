package net.minecraft.src;


public class PerlinNoise {
	public static double Noise2D(int x, int z, int seed)
    {
        int n;
        n = x + z * 57 + seed;
        n = (n << 13) ^ n;
        double res = (1.0 - ((n * (n * n * 15731 + 789221) + 1376312589) & 0x7fffffff) / 1073741824.0);
        return res;
    }

    public static double Noise1D(int x, int seed)
    {
        x = ((x + seed) << 13) ^ x;
        return (1.0 - ((x * (x * x * 15731 + 789221) + 1376312589) & 0x7fffffff) / 1073741824.0);
    }

    public static double SmoothNoise2D(int x, int z, int seed)
    {
        double corners = (Noise2D(x - 1, z - 1, seed) + Noise2D(x + 1, z - 1, seed) + Noise2D(x - 1, z + 1, seed) + Noise2D(x + 1, z + 1, seed)) / 16;
        double sides = (Noise2D(x - 1, z, seed) + Noise2D(x + 1, z, seed) + Noise2D(x, z - 1, seed) + Noise2D(x, z + 1, seed)) / 8;
        double center = Noise2D(x, z, seed) / 4;

        return corners + sides + center;
    }

    public static double SmoothNoise1D(int x, int seed)
    {
        return Noise1D(x, seed) / 2 + Noise1D(x - 1, seed) / 4 + Noise1D(x + 1, seed) / 4;
    }

    public static double LinearInterpolation(double a, double b, float x)
    {
        return a * (1 - x) + b * x;
    }

    public static double CosineInterpolation(double a, double b, float x)
    {
        double ft = x * 3.1415927d;
        double f = (1 - Math.cos(ft)) * 0.5;

        return a * (1 - f) + b * f;
    }

    public static double CubicInterpolation(int v0, int v1, int v2, int v3, float x)
    {
        double P = (v3 - v2) - (v0 - v1);
        double Q = (v0 - v1) - P;
        double R = v2 - v0;
        double S = v1;

        return Math.pow(P * x, 3) + Math.pow(Q *x, 2) + R*x + S;
    }

    public static double InterpolatedNoise2D(float x, float z, int seed)
    {
        int integerX = (int)x;
        float fractionalX = x - integerX;
         
        int integerY = (int)z;
        float fractionalY = z - integerY;

        double v1 = SmoothNoise2D(integerX, integerY, seed);
        double v2 = SmoothNoise2D(integerX + 1, integerY, seed);
        double v3 = SmoothNoise2D(integerX, integerY + 1, seed);
        double v4 = SmoothNoise2D(integerX + 1, integerY + 1, seed);

        double i1 = CosineInterpolation(v1 , v2 , fractionalX);
        double i2 = CosineInterpolation(v3 , v4 , fractionalX);

        return CosineInterpolation(i1, i2, fractionalY);
    }

    public static double InterpolatedNoise1D(float x, int seed)
    {
        int integerX = (int)x;
        float fractionalX = x - integerX;

        double v1 = SmoothNoise1D(integerX, seed);
        double v2 = SmoothNoise1D(integerX + 1, seed);

        return CosineInterpolation(v1, v2, fractionalX);
    }

    public static double PerlinNoise2D(float x, float z, double persistence, int NumberOfOctaves, int seed)
    {
        double total = 0;
        double p = persistence;
        int n = NumberOfOctaves - 1;

        for (int i = 0; i <= n; i++)
        {
            int frequency = 2^i;
            double amplitude = Math.pow(p, i);

            total = total + InterpolatedNoise2D(x * frequency, z * frequency, seed) * amplitude;
        }

        return total;
    }

    public static double AddPerlinNoise2D(float x, float z, int frequency, int amplitude, int seed)
    {
        return InterpolatedNoise2D(x * frequency, z * frequency, seed) * amplitude;
    }

    public static double PerlinNoise1D(float x, double persistence, int NumberOfOctaves, int seed)
    {
        double total = 0;
        double p = persistence;
        int n = NumberOfOctaves - 1;

        for (int i = 0; i <= n; i++)
        {
            int frequency = 2 ^ i;
            double amplitude = Math.pow(p, i);

            total = total + InterpolatedNoise1D(x * frequency, seed) * amplitude;
        }

        return total;
    }

    public static double AddPerlinNoise1D(float x, int frequency, int amplitude, int seed)
    {
        return InterpolatedNoise1D(x * frequency, seed) * amplitude;
    }

}
