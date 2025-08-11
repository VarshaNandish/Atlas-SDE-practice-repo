package com.example.bridge;

/**
 * Implementor interface in the Bridge pattern.
 * Concrete implementors (e.g., RedCircle, GreenCircle) implement this
 * interface to provide platform-specific drawing operations.
 */
public interface DrawAPI {
    void drawCircle(int radius, int x, int y);
}

