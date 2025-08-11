package com.example.prototype;

import java.util.Arrays;

/**
 * Demo client: shows how to register prototypes and create clones from them.
 */
public class PrototypeDriver {
    public static void main(String[] args) {
        // Create prototype instances
        Creeper creeperProto = new Creeper("creeper", 1.5, Arrays.asList("green leaves", "quick spread"));
        Shrub shrubProto = new Shrub("shrub", 0.8, Arrays.asList("dense foliage", "flowering"));

        // Create and populate registry
        PlantRegistry registry = new PlantRegistry();
        registry.addPrototype("basicCreeper", creeperProto);
        registry.addPrototype("gardenShrub", shrubProto);

        // Clone some plants from prototypes
        Plant p1 = registry.create("basicCreeper");
        Plant p2 = registry.create("basicCreeper");
        Plant p3 = registry.create("gardenShrub");

        // Show that clones are independent
        System.out.println("Before modification:");
        System.out.println(p1);
        System.out.println(p2);

        // If we cast to Creeper we can modify clone-specific fields
        ((Creeper)p1).addAttribute("new tendril");
        ((Creeper)p1).setLengthMeters(2.0);

        System.out.println("After modifying p1:");
        System.out.println(p1);
        System.out.println(p2); // p2 remains unchanged proving deep copy

        // Demonstrate growth
        p1.grow();
        p3.grow();
    }
}

