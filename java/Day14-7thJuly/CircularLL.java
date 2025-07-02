public class CircularLL {

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

        // Create nodes
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        // Link the nodes
        first.next = second;
        second.next = third;
        third.next = first;       // Third to First (circle completed)

        // Traversing the circular linked list
        Node current = first;        // Start from the head (first)
        System.out.print("Circular Linked List: ");

        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != first);              // Stop when back at the start
    }
}


