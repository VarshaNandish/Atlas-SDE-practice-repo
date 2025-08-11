package com.example.bridge;

/**
 * Abstraction in the Bridge pattern. It holds a reference to an Implementor
 * (DrawAPI) and delegates the actual drawing to that implementor.
 */
public abstract class Shape {
    // Composition: the Abstraction refers to the Implementor interface
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    // Operation exposed by the Abstraction
    public abstract void draw();

    // Optional helper to change the Implementor at runtime
    public void setDrawAPI(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }
}

