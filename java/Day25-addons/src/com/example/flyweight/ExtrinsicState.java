package com.example.flyweight;

/**
 * Holds extrinsic state which is passed to flyweights at runtime.
 * This data is not stored inside flyweight instances because it varies
 * between contexts.
 */
public class ExtrinsicState {
    private final String fontName;
    private final int fontSize;
    private final int x;
    private final int y;

    public ExtrinsicState(String fontName, int fontSize, int x, int y) {
        this.fontName = fontName;
        this.fontSize = fontSize;
        this.x = x;
        this.y = y;
    }

    public String getFontName() { return fontName; }
    public int getFontSize() { return fontSize; }
    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public String toString() {
        return String.format("font=%s,size=%d,pos=(%d,%d)", fontName, fontSize, x, y);
    }
}
