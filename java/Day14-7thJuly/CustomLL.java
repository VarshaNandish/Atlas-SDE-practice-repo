public class CustomLL {

    // Custom Node class
    static class Node {
        int data;
        Node next;

        // Constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // Creating nodes
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        // Linking nodes
        first.next = second;
        second.next = third;

        // Traversing and displaying the list
        Node current = first;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}


