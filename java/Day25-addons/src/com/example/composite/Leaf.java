package com.example.composite;

/**
 * Leaf represents end objects in the composition.
 * It implements all Component methods.
 */
public class Leaf implements Component {

    // variable to store brand name
    private final String name;

    // constructor to set brand name
    public Leaf(String name) {
        this.name = name;
    }

    // implementation of the brandName() method
    @Override
    public void brandName() {
        System.out.println("Brand: " + name);
    }
}
