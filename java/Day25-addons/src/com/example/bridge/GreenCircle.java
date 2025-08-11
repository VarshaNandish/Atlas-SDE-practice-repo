package com.example.bridge;

/**
 * ConcreteImplementor 2: draws a circle using "Green" color semantics.
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.printf("Drawing Circle[color=Green, radius=%d, x=%d, y=%d]%n", radius, x, y);
    }
}
