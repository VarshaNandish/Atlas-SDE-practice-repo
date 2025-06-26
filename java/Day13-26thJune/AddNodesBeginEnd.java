public class AddNodesBeginEnd {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node addAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    static Node addAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    static void printList(Node head) {
        System.out.print("Linked List: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;

        head = addAtEnd(head, 10);
        head = addAtEnd(head, 20);

        head = addAtBeginning(head, 5);

        head = addAtEnd(head, 30);

        printList(head);
    }
}

