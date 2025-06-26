import java.util.LinkedList;
import java.util.Spliterator;

public class SplitLL {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        Spliterator<String> sp1 = list.spliterator();

        Spliterator<String> sp2 = sp1.trySplit();

        System.out.println("List 1:");
        if (sp2 != null) {
            sp2.forEachRemaining(System.out::println);
        }
        System.out.println("List 2:");
        sp1.forEachRemaining(System.out::println);
    }
}
