import java.util.Stack;

public class StackSearch {

    public static void main(String[] args) {

        Stack<String> names = new Stack<>();

        names.push("V");
        names.push("a");
        names.push("r");
        names.push("s");
        names.push("h");
        //names.push("a");

        System.out.println("Stack: " + names);

        int position = names.search("a");

        if (position != -1) {
            System.out.println("found at position: " + position);
        } else {
            System.out.println("not found in the stack.");

        }
    }
}

