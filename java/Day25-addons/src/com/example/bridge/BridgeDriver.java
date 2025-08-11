package com.example.bridge;

/**
 * Client code demonstrating using the Bridge pattern. The client creates
 * different combinations of Abstractions (Shapes) and Implementors (DrawAPI)
 * and can even swap implementors at runtime.
 */
public class BridgeDriver {
    public static void main(String[] args) {
        // Create shapes with specific implementors
        Shape redCircle = new Circle(10, 20, 15, new RedCircle());
        Shape greenCircle = new Circle(30, 40, 10, new GreenCircle());

        // Draw using the implementors provided at construction
        redCircle.draw();    // prints a Red circle description
        greenCircle.draw();  // prints a Green circle description

        // Demonstrate runtime switching of implementor
        redCircle.setDrawAPI(new GreenCircle());
        redCircle.draw();    // now prints a Green circle even though it is a Circle
    }
}

