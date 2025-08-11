package com.example.prototype;

/**
 * Prototype interface for plants. Declares the prototypical clone method
 * and basic plant behaviour.
 */
public interface Plant {
    // High-level behaviour every plant must implement
    void grow();

    // Accessors for a generic growth type (e.g., "creeper", "shrub")
    String getGrowthType();
    void setGrowthType(String growthType);

    // Prototype method: return a copy (clone) of this object
    Plant clone();
}

