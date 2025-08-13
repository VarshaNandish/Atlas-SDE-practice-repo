package com.example.StructuralMethodDP.Command;

/**
 * Receiver - Knows how to perform the operations.
 */
public class TxtFile {
    private String name;

    // Constructor
    public TxtFile(String name) {
        this.name = name;
    }

    public String open() {
        return name + " is opening";
    }

    public String save() {
        return name + " is saving";
    }

    public String close() {
        return name + " is closing";
    }
}
