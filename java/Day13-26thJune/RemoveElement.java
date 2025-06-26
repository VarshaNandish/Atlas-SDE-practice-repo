import java.util.LinkedList;

public class RemoveElement {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        System.out.println("Original List: " + list);

        list.remove("Four");

        System.out.println("Updated List: " + list);
    }
}


