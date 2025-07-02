import java.util.Stack;

public class StackPeek {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(100);
        stack.push(200);
        stack.push(300);

        System.out.println("Stack: " + stack);

        int peekedElement = stack.peek();

        System.out.println("Peeked or the t`op element is: " + peekedElement);
        System.out.println("After peeking: " + stack);
    }
}


