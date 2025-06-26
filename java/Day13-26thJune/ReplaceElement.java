import java.util.LinkedList;

public class ReplaceElement {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        System.out.println("Original List: " + list);

        list.set(2, "Replaced");

        System.out.println("Updated List: " + list);
    }
}

