import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> numbers =  Arrays.asList(1, 2, 3, 4, 5, 4, 1);
        List<Integer> RemovDups = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Original list: " + numbers);
        System.out.println("List after removing duplicates: " + RemovDups);
    }
}

