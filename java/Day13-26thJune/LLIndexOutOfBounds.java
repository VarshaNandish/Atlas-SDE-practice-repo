public class LLIndexOutOfBounds {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node getNodeAt(Node head, int index) {
        int count = 0;
        Node current = head;

        while (current != null) {
            if (count == index) {
                return current;
            }
            count++;
            current = current.next;
        }

        throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");

    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        System.out.println("Value at index 1: " + getNodeAt(head, 1).data);

        System.out.println("Value at index 5: " + getNodeAt(head, 5).data);
    }
}

