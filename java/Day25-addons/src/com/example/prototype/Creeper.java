package com.example.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete prototype: a creeper plant. Supports cloning via copy constructor.
 */
public class Creeper implements Plant {
    private String growthType;
    private double lengthMeters; // how long the creeper grows
    private List<String> attributes; // example of a mutable field to demonstrate deep copy

    // Primary constructor
    public Creeper(String growthType, double lengthMeters, List<String> attributes) {
        this.growthType = growthType;
        this.lengthMeters = lengthMeters;
        // Defensive copy to avoid external mutation
        this.attributes = new ArrayList<>();
        if (attributes != null) this.attributes.addAll(attributes);
    }

    // Copy constructor used by clone() to perform deep copy
    public Creeper(Creeper other) {
        this.growthType = other.growthType;
        this.lengthMeters = other.lengthMeters;
        this.attributes = new ArrayList<>(other.attributes);
    }

    @Override
    public void grow() {
        System.out.println("Creeper grows by extending its vines. Current length: " + lengthMeters + " m");
    }

    @Override
    public String getGrowthType() {
        return growthType;
    }

    @Override
    public void setGrowthType(String growthType) {
        this.growthType = growthType;
    }

    public double getLengthMeters() {
        return lengthMeters;
    }

    public void setLengthMeters(double lengthMeters) {
        this.lengthMeters = lengthMeters;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void addAttribute(String attr) {
        this.attributes.add(attr);
    }

    @Override
    public Plant clone() {
        return new Creeper(this); // deep copy via copy constructor
    }

    @Override
    public String toString() {
        return "Creeper{" + "growthType='" + growthType + '\'' + ", lengthMeters=" + lengthMeters + ", attributes=" + attributes + '}';
    }
}
