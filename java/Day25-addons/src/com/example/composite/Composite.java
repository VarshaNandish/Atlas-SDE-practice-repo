package com.example.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite stores child components (could be Leafs or other Composites)
 * and implements the same interface as the leaves.
 */
public class Composite implements Component {

    // variable to store the composite group name
    private final String groupName;

    // list to store child components
    private final List<Component> components = new ArrayList<>();

    // constructor to set group name
    public Composite(String groupName) {
        this.groupName = groupName;
    }

    // add a subcomponent (leaf or another composite)
    public void add(Component subComponent) {
        components.add(subComponent);
    }

    // remove a subcomponent
    public void remove(Component subComponent) {
        components.remove(subComponent);
    }

    // override brandName() to call brandName() on all children
    @Override
    public void brandName() {
        System.out.println("Group: " + groupName);
        for (Component comp : components) {
            comp.brandName();
        }
    }
}
