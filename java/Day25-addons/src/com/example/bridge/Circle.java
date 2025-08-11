package com.example.bridge;

/**
 * RefinedAbstraction: a concrete Shape that delegates drawing to the
 * DrawAPI implementor.
 */
public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        // Delegation: the Shape delegates implementation-specific work
        // to the DrawAPI implementor.
        drawAPI.drawCircle(radius, x, y);
    }
}
