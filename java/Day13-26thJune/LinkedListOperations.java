public class LinkedListOperations {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
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

    static Node removeNode(Node head, int value) {
        if (head == null)
            return null;

        /*if (head.data == value) {
            return head.next;
        }*/

        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }

        //System.out.println("Value " + value + " not found in the list.");
        return head;
    }


    /*static int getValueAtIndex(Node head, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index must be non-negative.");
        }

        Node current = head;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                return current.data;
            }
            current = current.next;
            currentIndex++;
        }

        throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
    } */




    static int getSize(Node head) {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        first.next = second;
        second.next = third;
        third.next = fourth;

        printList(first);

        first = removeNode(first, 30);

        printList(first);

        int size = getSize(first);
        System.out.println("Size of linked list: " + size);

       // System.out.println("Value at index 2: " + getValueAtIndex(first, 2)); // ✅ 300

       // System.out.println("Value at index 5: " + getValueAtIndex(first, 5));
    }
}

