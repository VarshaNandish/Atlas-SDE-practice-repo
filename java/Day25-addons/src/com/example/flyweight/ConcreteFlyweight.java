package com.example.flyweight;

/**
 * ConcreteFlyweight stores intrinsic state (shared) such as the character
 * glyph. It performs operations that also use extrinsic state provided
 * at call time.
 */
public class ConcreteFlyweight implements Flyweight {
    private final char intrinsicState; // e.g., the character/glyph

    public ConcreteFlyweight(char intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    public char getIntrinsicState() { return intrinsicState; }

    @Override
    public void operation(ExtrinsicState state) {
        // In a real UI this would render the glyph using font/position info.
        System.out.printf("Displaying '%c' with %s%n", intrinsicState, state);
    }
}

