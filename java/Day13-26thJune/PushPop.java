import java.util.LinkedList;

public class PushPop {
    public static void main(String[] args) {
        LinkedList<String> stack = new LinkedList<>();

        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");

        System.out.println("After pushing: " + stack); // Cherry is at top

        String popped = stack.pop();

        System.out.println("Popped element: " + popped);
        System.out.println("After popping: " + stack);
    }
}

