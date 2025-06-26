import java.util.LinkedList;

public class ConvertLLToArray2 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");

        System.out.println("LinkedList: " + list);

        String[] array = list.toArray(new String[0]);

        System.out.print("Array: ");
        for (String item : array) {
            System.out.print(item + " ");
        }
    }
}
