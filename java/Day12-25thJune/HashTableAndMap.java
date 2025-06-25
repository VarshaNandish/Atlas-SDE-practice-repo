import java.util.HashMap;
import java.util.Hashtable;

public class HashTableAndMap {
    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        // put()
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        hashMap.put("Charlie", 28);
        // get()
        System.out.println("HashMap - Bob's Age: " + hashMap.get("Bob"));
        System.out.println("\nHashMap Contents:");
        for (String name : hashMap.keySet()) {
            System.out.println(name + " → " + hashMap.get(name));
        }

        Hashtable<String, Integer> hashTable = new Hashtable<>();
        // put()
        hashTable.put("David", 35);
        hashTable.put("Emma", 29);
        hashTable.put("Frank", 40);
        // get()
        System.out.println("\nHashtable - Emma's Age: " + hashTable.get("Emma"));

        System.out.println("\nHashtable Contents:");
        for (String name : hashTable.keySet()) {
            System.out.println(name + " → " + hashTable.get(name));
        }
    }
}
