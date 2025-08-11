package com.example.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Factory that creates and manages flyweight objects. It ensures sharing
 * of flyweights by reusing existing instances for the same intrinsic key.
 */
public class FlyweightFactory {
    private final Map<Character, Flyweight> pool = new ConcurrentHashMap<>();

    public Flyweight getFlyweight(char key) {
        // computeIfAbsent atomically creates and stores a new flyweight if needed
        return pool.computeIfAbsent(key, k -> new ConcreteFlyweight(k));
    }

    public int getPoolSize() {
        return pool.size();
    }
}
