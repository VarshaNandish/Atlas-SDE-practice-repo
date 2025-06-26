import java.util.LinkedList;
import java.util.Arrays;

public class DisplayLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));

        System.out.println("Using for loop with get():");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("\nUsing for-each loop:");
        for (String item : list) {
            System.out.println(item);
        }
    }
}

