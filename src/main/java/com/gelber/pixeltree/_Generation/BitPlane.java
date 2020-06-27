package com.gelber.pixeltree._Generation;

import java.util.ArrayList;

public class BitPlane {
    private int width;
    private int height;
    private Bit[][] plane;

    public BitPlane(int width, int height) {
        this.width = width;
        this.height = height;

        plane = new Bit[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                plane[i][j] = new Bit(i, j);
            }
        }
    }

    public Bit get(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return null;
        }
        return plane[x][y];
    }

    public Bit get(Bit bit) {
        return get(bit.x, bit.y);
    }

    public Bit set(int x, int y, boolean on) {
        if (x < 0 || x >= plane.length || y < 0 || y > plane[0].length) {
            return null;
        }

        plane[x][y].on = on;
        return plane[x][y];
    }

    public Bit set(Bit bit, boolean on) {
        if (bit.x >= width || bit.y >= height) {
            return null;
        }

        return set(bit.x, bit.y, on);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Bit[][] getBits() {
        return plane;
    }
}
