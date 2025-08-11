package com.example.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete prototype: a shrub. Also supports cloning.
 */
public class Shrub implements Plant {
    private String growthType;
    private double heightMeters; // average height
    private List<String> features;

    public Shrub(String growthType, double heightMeters, List<String> features) {
        this.growthType = growthType;
        this.heightMeters = heightMeters;
        this.features = new ArrayList<>();
        if (features != null) this.features.addAll(features);
    }

    public Shrub(Shrub other) {
        this.growthType = other.growthType;
        this.heightMeters = other.heightMeters;
        this.features = new ArrayList<>(other.features);
    }

    @Override
    public void grow() {
        System.out.println("Shrub grows by increasing foliage and height. Current height: " + heightMeters + " m");
    }

    @Override
    public String getGrowthType() {
        return growthType;
    }

    @Override
    public void setGrowthType(String growthType) {
        this.growthType = growthType;
    }

    public double getHeightMeters() {
        return heightMeters;
    }

    public void setHeightMeters(double heightMeters) {
        this.heightMeters = heightMeters;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void addFeature(String f) {
        this.features.add(f);
    }

    @Override
    public Plant clone() {
        return new Shrub(this);
    }

    @Override
    public String toString() {
        return "Shrub{" + "growthType='" + growthType + '\'' + ", heightMeters=" + heightMeters + ", features=" + features + '}';
    }
}

