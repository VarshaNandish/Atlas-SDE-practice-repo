package Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Strategy Interface
interface SortingStrategy {
    void sort(List<String> items);
}

// Concrete Strategy 1: Alphabetical (case-insensitive)
class AlphabeticalSort implements SortingStrategy {
    @Override
    public void sort(List<String> items) {
        Collections.sort(items, String.CASE_INSENSITIVE_ORDER);
    }
}

// Concrete Strategy 2: Length-wise sorting
class LengthwiseSort implements SortingStrategy {
    @Override
    public void sort(List<String> items) {
        Collections.sort(items, Comparator.comparingInt(String::length));
    }
}

// Context class
class SortingContext {
    private SortingStrategy strategy;
    private final List<String> items;

    public SortingContext() {
        items = new ArrayList<>();
    }

    // Set the sorting strategy dynamically
    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    // Add items
    public void addItem(String item) {
        items.add(item);
    }

    // Remove items
    public void removeItem(String item) {
        items.remove(item);
    }

    // Perform sorting using current strategy
    public void performSort() {
        if (strategy != null) {
            strategy.sort(items);
        } else {
            System.out.println("No sorting strategy set!");
        }
    }

    // Retrieve sorted list
    public List<String> getList() {
        return new ArrayList<>(items); // defensive copy
    }
}

// Main class to demonstrate functionality
public class SortingStrategyMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SortingContext context = new SortingContext();

        System.out.println("Enter items (type 'Done' to finish):");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("Done")) break;
            context.addItem(input);
        }

        // Alphabetical Sorting
        context.setStrategy(new AlphabeticalSort());
        context.performSort();
        System.out.println("\nAlpha sorting:");
        for (String s : context.getList()) {
            System.out.println(s);
        }

        // Lengthwise Sorting
        context.setStrategy(new LengthwiseSort());
        context.performSort();
        System.out.println("\nLengthwise sorting:");
        for (String s : context.getList()) {
            System.out.println(s);
        }

        sc.close();
    }
}
