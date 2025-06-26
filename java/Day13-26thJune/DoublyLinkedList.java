public class DoublyLinkedList {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    Node head;

    void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }


    void delete(int value) {
        Node temp = head;

        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value " + value + " not found in the list.");
            return;
        }

        if (temp == head) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
        }

        System.out.println("Deleted: " + value);
    }

    void printList() {
        Node temp = head;
        System.out.print("Doubly Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        list.printList();

        list.delete(20);
        list.printList();

        list.delete(10);
        list.printList(); 

        list.delete(100);
    }
}

