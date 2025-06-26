import java.util.LinkedList;
import java.util.Arrays;

public class ConvertLLToArray {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date"));

        System.out.println("LinkedList: " + list);

        String[] array = list.toArray(new String[0]);

        System.out.println("Array: " + Arrays.toString(array));
    }
}

