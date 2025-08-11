package com.example.flyweight;

/**
 * Client/demo showing how flyweights are reused to render a document.
 */
public class FlyweightDriver {
    public static void main(String[] args) {
        String document = "ABRACADABRA"; // repeated characters

        FlyweightFactory factory = new FlyweightFactory();

        for (int i = 0; i < document.length(); i++) {
            char c = document.charAt(i);

            // Request a shared flyweight for the character
            Flyweight fw = factory.getFlyweight(c);

            // Create extrinsic state (varies per occurrence)
            ExtrinsicState state = new ExtrinsicState("Arial", 12 + (i % 3) * 2, i * 10, i / 2);

            // Use the flyweight with extrinsic state
            fw.operation(state);
        }

        System.out.println("Total flyweights created: " + factory.getPoolSize());
        System.out.println("Document length: " + document.length());

        // Expected: pool size equals number of distinct characters in the document
    }
}

