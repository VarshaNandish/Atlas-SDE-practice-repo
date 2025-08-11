package com.example.flyweight;

/**
 * Flyweight interface declares an operation that takes extrinsic state.
 */
public interface Flyweight {
    void operation(ExtrinsicState state);
}
