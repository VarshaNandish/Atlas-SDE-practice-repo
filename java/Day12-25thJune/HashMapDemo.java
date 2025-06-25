import java.util.HashMap;

public class HashMapDemo {
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

    }
}