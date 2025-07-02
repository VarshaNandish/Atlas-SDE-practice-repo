import java.util.Stack;

public class StackEmpty2 {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("Java");
        stack.push("Python");

        String message = stack.isEmpty() ? "Stack is empty." : "Stack is not empty.";

        System.out.println(message);

    }
}


