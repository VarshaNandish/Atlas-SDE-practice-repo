package Singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DataManager {

    // Singleton instance
    private static DataManager instance;

    // Thread-safe list
    private final List<String> items;

    // Private constructor
    private DataManager() {
        if (instance != null) {
            throw new IllegalStateException("Singleton instance already exists!");
        }
        items = Collections.synchronizedList(new ArrayList<>());
    }

    // Synchronized method to get singleton instance
    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    // Add item
    public synchronized void addItem(String item) {
        items.add(item);
    }

    // Remove item
    public synchronized void removeItem(String item) {
        items.remove(item);
    }

    // Get items
    public synchronized List<String> getItems() {
        return new ArrayList<>(items); // return copy for safety
    }

    // MAIN
    public static void main(String[] args) {
        DataManager manager = DataManager.getInstance();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter items (type 'Done' to finish):");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("Done")) {
                break;
            }
            manager.addItem(input);
        }

        System.out.println("Enter an item to remove:");
        String itemToRemove = sc.nextLine();
        manager.removeItem(itemToRemove);

        // Print final list
        System.out.println("Final Items:");
        for (String item : manager.getItems()) {
            System.out.println(item);
        }

        sc.close();
    }
}

