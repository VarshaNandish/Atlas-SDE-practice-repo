package com.example.composite;

/**
 * Demo class to show how Composite pattern works.
 */
public class CompositeDriver {
    public static void main(String[] args) {
        // Create leaf brands
        Component dell = new Leaf("Dell");
        Component hp = new Leaf("HP");
        Component lenovo = new Leaf("Lenovo");

        Component bmw = new Leaf("BMW");
        Component audi = new Leaf("Audi");

        // Create composite groups
        Composite laptopBrands = new Composite("Laptop Brands");
        laptopBrands.add(dell);
        laptopBrands.add(hp);
        laptopBrands.add(lenovo);

        Composite carBrands = new Composite("Car Brands");
        carBrands.add(bmw);
        carBrands.add(audi);

        // Create top-level composite
        Composite allBrands = new Composite("All Brands");
        allBrands.add(laptopBrands);
        allBrands.add(carBrands);

        // Call brandName() on the top composite
        allBrands.brandName();
    }
}
