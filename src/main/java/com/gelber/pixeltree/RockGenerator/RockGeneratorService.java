package com.gelber.pixeltree.RockGenerator;

import com.gelber.pixeltree._Generation.Color;
import com.gelber.pixeltree._Generation.FastNoise;
import com.gelber.pixeltree._Generation.PNGImage;
import org.springframework.stereotype.Service;

import javax.vecmath.Point2d;
import javax.vecmath.Vector2f;
import javax.vecmath.Vector3f;

@Service
public class RockGeneratorService {
    private float scale = 5;

    public void generate() {
        PNGImage image = new PNGImage(32, 32);
        FastNoise noise = new FastNoise();
        noise.SetNoiseType(FastNoise.NoiseType.Perlin);
        noise.SetSeed((int)(Math.random() * 100000));
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                float normalizedNoise = noise.GetPerlin(i * scale, j * scale) / 2 + 0.5f;
                if (normalizedNoise * mask(i, j) > 0.2f) {
                    image.setPixel(i, j, new Color(0, 0, 0));
                }
            }
        }
        image.write("C:\\Users\\Daniel\\Pictures\\gameart\\0.png");
    }

    public double mask(int x, int y) {
        Point2d origin = new Point2d(16, 16);
        Point2d point = new Point2d(x, y);
        double dist = origin.distance(point);
        return 1 - (dist / 16);
    }
}
