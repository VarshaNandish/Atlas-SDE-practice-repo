public class AddNode {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);


        first.next = second;
        second.next = third;


        Node current = first;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

