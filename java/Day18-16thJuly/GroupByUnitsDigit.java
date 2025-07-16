import java.util.*;

public class GroupByUnitsDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numbers separated by commas:");
        String input = sc.nextLine();

        String[] tokens = input.split(",");
        Map<Integer, List<Integer>> groups = new HashMap<>();

        for (String token : tokens) {
            token = token.trim();
            if (!token.isEmpty()) {
                int num = Integer.parseInt(token);
                int unitDigit = num % 10;

                groups.computeIfAbsent(unitDigit, k -> new ArrayList<>()).add(num);
            }
        }

        int arrayNumber = 1;
        for (Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
            System.out.println("Array " + arrayNumber + " has: " + entry.getValue());
            arrayNumber++;
        }
    }
}

