import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FilterOddNumbers {
    public static void main(String[] args) {
        List<Integer> numbers =  Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Odd numbers in the list:");
        numbers.stream()
                .filter(n -> n % 2 != 0)
                .forEach(System.out::println);
    }
}

