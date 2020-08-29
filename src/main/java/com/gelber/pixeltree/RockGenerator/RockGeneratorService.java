package com.gelber.pixeltree.RockGenerator;

import com.gelber.pixeltree._Generation.Color;
import com.gelber.pixeltree._Generation.FastNoise;
import com.gelber.pixeltree._Generation.PNGImage;
import org.springframework.stereotype.Service;

import javax.vecmath.Point2d;
import javax.vecmath.Point3d;
import javax.vecmath.Vector2f;
import javax.vecmath.Vector3f;

@Service
public class RockGeneratorService {
    private float scale = 10;
    private int size = 512;

    public void generate(int size, int scale, int picNumber) {
        this.size = size;
        this.scale = scale;
        PNGImage image = new PNGImage(size, size);
        FastNoise noise = new FastNoise();
        noise.SetNoiseType(FastNoise.NoiseType.Perlin);
        noise.SetSeed((int)(Math.random() * 100000));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    float normalizedNoise = noise.GetPerlin(i * scale, j * scale, k * scale) / 2 + 0.5f;
                    if (normalizedNoise * mask(i, j, k) > 0.2f) {
                        image.setPixel(j, k, new Color(i * (256 / size), i * (256 / size), i * (256 / size)));
                    }
                }
            }
        }
        image.write("C:\\Users\\Daniel\\Pictures\\gameart\\" + picNumber + ".png");
    }

    public double mask(int x, int y, int z) {
        Point3d origin = new Point3d(size / 2, size / 2, size / 2);
        Point3d point = new Point3d(x, y, z);
        double dist = origin.distance(point);
        return 1 - (dist / (size / 2));
    }
}
