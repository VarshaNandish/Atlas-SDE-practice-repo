import java.util.LinkedList;

public class CloneLL {
    public static void main(String[] args) {
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("Pen");
        list1.add("Pencil");
        list1.add("Eraser");
        list1.add("Sharpener");

        System.out.println("Original List (list1): " + list1);

        LinkedList<String> list2 = (LinkedList<String>) list1.clone();

        System.out.println("Cloned List (list2): " + list2);
    }
}

