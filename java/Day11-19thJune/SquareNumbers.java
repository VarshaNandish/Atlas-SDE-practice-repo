import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SquareNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numbers separated by spaces: ");
        String inputLine = scanner.nextLine();

        List<Integer> numbers = Arrays.stream(inputLine.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Original numbers: " + numbers);

        System.out.println("Squared numbers:");
        numbers.stream()
                .map(n -> n * n)
                .forEach(System.out::println);

        scanner.close();
    }
}
