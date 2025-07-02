import java.util.Stack;

public class StackEmpty1 {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        if (stack.isEmpty()) {
            System.out.println("Stack is currently empty.");
        } else {
            System.out.println("Stack is not empty.");
        }

        stack.push("Java");
        stack.push("Python");

        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack is not empty.");

        }
    }
}

