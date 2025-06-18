class Counter2 {
    private int count = 0;

    // Only this block is synchronized, not the entire method
    public void increment() {
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}

class ThreadDemo3 extends Thread {
    Counter counter;

    ThreadDemo3(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class Task6 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ThreadDemo3 t1 = new ThreadDemo3(counter);
        ThreadDemo3 t2 = new ThreadDemo3(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
