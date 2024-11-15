package me;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Color {

    private final int r;
    private final int g;
    private final int b;

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Color color = (Color) o;
        return r == color.r
                && g == color.g
                && b == color.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, g, b);
    }

    public static void main(String[] args) {
        Color green1 = new Color(0, 1, 0);
        Color green2 = new Color(0, 1, 0);
        System.out.println(green1.equals(green2));

        Set<Color> colors = new HashSet<>();
        colors.add(green1);
        colors.add(green2);
        System.out.println(colors.size());
    }
}
