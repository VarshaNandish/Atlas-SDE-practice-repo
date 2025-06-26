import java.util.LinkedList;

public class LinkedListExample {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.addFirst("Orange");
        fruits.addLast("Grapes");

        System.out.println("First element: " + fruits.getFirst());
        System.out.println("Last element: " + fruits.getLast());

        fruits.removeFirst();
        fruits.removeLast();

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}

