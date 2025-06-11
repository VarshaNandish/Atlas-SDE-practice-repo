public class Task13 {
    public static void main(String[] args) {
        for (int i = 10; i >= 1; i--) {
            if (i == 7 || i == 5) {
                continue; // Skip 7 and 5
            }
            System.out.println(i);
        }
    }
}
