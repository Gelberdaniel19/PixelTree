package com.gelber.pixeltree._Generation;

public class Color {
    public int R;
    public int G;
    public int B;
    public int A;

    public Color(int r, int g, int b, int a) {
        this.R = r;
        this.G = g;
        this.B = b;
        this.A = a;
    }

    public Color(int r, int g, int b) {
        this.R = r;
        this.G = g;
        this.B = b;
        this.A = 255;
    }

    public String toString() {
        return "Color: (" + R + ", " + G + ", " + B + ")";
    }

    public boolean equals(Color c) {
        return c.R == R && c.G == G && c.B == B && c.A == A;
    }
}
