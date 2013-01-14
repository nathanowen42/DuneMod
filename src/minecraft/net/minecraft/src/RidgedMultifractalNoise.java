package net.minecraft.src;


public class RidgedMultifractalNoise {
	public static double RidgedMultifractalNoise2D(float x, float z, int NumberOfOctaves, float persistence, float hScale, float vScale, float offset, int seed)
    {
        double total = 0;
        int n = NumberOfOctaves;
        double prev = 1.0;
        x *= hScale;
        z *= hScale;
        
        for (int i = 0; i < n; i++)
        {
            float frequency = 2^i;
            double amplitude = Math.pow(persistence, i);
            double tmp = ridge(InterpolatedNoise2D(x * frequency, z * frequency, seed), offset);
            total += tmp * amplitude * prev;
            prev = tmp;
        }

        return total * vScale;
    }

    public static double AddRidgedMultifractalNoise2D(float x, float z, int NumberOfOctaves, float frequency, float amplitude, float hScale, float vScale, float offset, int seed)
    {
        x *= hScale;
        z *= hScale;
        double tmp = ridge(InterpolatedNoise2D(x * frequency, z * frequency, seed), offset);
        return tmp * amplitude * vScale;
    }

    public static double ridge(double h, float offset)
    {
        h = Math.abs(h);
        h = offset - h;
        h = h * h;
        return h;
    }

    public static double Noise2D(int x, int z, int seed)
    {
        int n;
        n = x + z * 57 + seed;
        n = (n << 13) ^ n;
        double res = (1.0 - ((n * (n * n * 15731 + 789221) + 1376312589) & 0x7fffffff) / 1073741824.0);
        return res;
    }

    private static double InterpolatedNoise2D(float x, float y, int seed)
    {
        int integer_X = (int)x;
        float fractional_X = x - integer_X;

        int integer_Y = (int)y;
        float fractional_Y = y - integer_Y;

        double v1 = SmoothNoise2D(integer_X, integer_Y, seed);
        double v2 = SmoothNoise2D(integer_X + 1, integer_Y, seed);
        double v3 = SmoothNoise2D(integer_X, integer_Y + 1, seed);
        double v4 = SmoothNoise2D(integer_X + 1, integer_Y + 1, seed);

        double i1 = CosineInterpolation(v1, v2, fractional_X);
        double i2 = CosineInterpolation(v3, v4, fractional_X);

        return CosineInterpolation(i1, i2, fractional_Y);
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
    
    public static double SmoothNoise2D(int x, int z, int seed)
    {
        double corners = (Noise2D(x - 1, z - 1, seed) + Noise2D(x + 1, z - 1, seed) + Noise2D(x - 1, z + 1, seed) + Noise2D(x + 1, z + 1, seed)) / 16;
        double sides = (Noise2D(x - 1, z, seed) + Noise2D(x + 1, z, seed) + Noise2D(x, z - 1, seed) + Noise2D(x, z + 1, seed)) / 8;
        double center = Noise2D(x, z, seed) / 4;

        return corners + sides + center;
    }
}
