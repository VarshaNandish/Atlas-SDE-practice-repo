import java.util.LinkedList;
import java.util.ListIterator;

public class LLIterator {

    public static void main(String args[]) {

        LinkedList<String> list = new LinkedList<>();
        list.add("Varsha");
        list.add("Nandish");
        list.add("Navishka");

        ListIterator<String> iter = list.listIterator();

        System.out.println("Iterating using ListIterator:");
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}
