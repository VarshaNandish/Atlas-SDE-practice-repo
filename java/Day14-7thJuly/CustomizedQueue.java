public class CustomizedQueue {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;}
    }

    Node front, rear;

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Enqueued: " + data);
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        System.out.println("Dequeued: " + front.data);
        front = front.next;
        if (front == null) rear = null;
    }

    void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Front element: " + front.data);
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        Node current = front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.data + " ");current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        CustomizedQueue queue = new CustomizedQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        queue.peek();

        queue.dequeue();

        queue.display();

        queue.enqueue(40);
        queue.enqueue(50);

        queue.display();

    }

}


