import java.util.Stack;
import java.util.ArrayList;


public class StackPop {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Original Stack: " + stack);

        ArrayList<Integer> poppedElements = new ArrayList<>();

        while (!stack.isEmpty()) {
            int popped = stack.pop();
            poppedElements.add(popped);
        }

        System.out.println("Popped Elements: " + poppedElements);

        System.out.println("Stack after popping: " + stack);

    }
}


