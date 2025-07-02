public class CustomisedQueue {

    int[] queue;
    int front;
    int rear;
    int capacity;

    CustomisedQueue(int size) {
        capacity = size;
        queue = new int[capacity];
        front = 0;
        rear = -1;
    }

    boolean isEmpty() {
        return front > rear;
    }

    boolean isFull() {
        return rear == capacity - 1;
    }

    void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot add " + data);
            return;
        }
        rear++;
        queue[rear] = data;
        System.out.println("Added: " + data);
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot delete.");
            return;
        }
        System.out.println("Deleted: " + queue[front]);
        front++;
    }

    void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return;
        }
        System.out.println("Front element is: " + queue[front]);
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Displaying all the elements in queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        CustomisedQueue que = new CustomisedQueue(6);

        que.enqueue(1);
        que.enqueue(2);
        que.enqueue(3);

        que.display();

        que.peek();

        que.dequeue();

        que.display();

        que.enqueue(4);
        que.enqueue(5);
        que.enqueue(6);
        que.enqueue(7);

        que.display();
    }
}

