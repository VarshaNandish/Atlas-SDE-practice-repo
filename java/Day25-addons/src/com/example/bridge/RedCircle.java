package com.example.bridge;

/**
 * ConcreteImplementor 1: draws a circle using "Red" color semantics.
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.printf("Drawing Circle[color=Red, radius=%d, x=%d, y=%d]%n", radius, x, y);
    }
}
