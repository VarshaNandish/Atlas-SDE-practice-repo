import java.util.LinkedList;
import java.util.Spliterator;

public class SplitLL3 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        list.add("Elderberry");

        Spliterator<String> itobj1 = list.spliterator();
        Spliterator<String> itobj2 = itobj1.trySplit();

        System.out.println("Spliterator 1:");
        while (itobj1.tryAdvance((n) -> { System.out.println(n); }));

        System.out.println("Spliterator 2:");
        while (itobj2.tryAdvance((n) -> { System.out.println(n); }));
    }
}
