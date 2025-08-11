package com.example.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple registry/factory that stores prototype instances and returns clones.
 */
public class PlantRegistry {
    private Map<String, Plant> prototypes = new HashMap<>();

    // Register a prototype under a key
    public void addPrototype(String key, Plant prototype) {
        prototypes.put(key, prototype);
    }

    // Create a new plant by cloning the registered prototype
    public Plant create(String key) {
        Plant p = prototypes.get(key);
        if (p == null) return null;
        return p.clone();
    }
}

