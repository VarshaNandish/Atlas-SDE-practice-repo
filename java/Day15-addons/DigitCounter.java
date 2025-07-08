public class DigitCounter {

    // Recursive function to count digits
    public static int countDigits(int num) {

        // Base case: when number is 0
        if (num == 0) {
            return 0;
        }

        // Recursive step: strip one digit and count
        return 1 + countDigits(num / 10);
    }

    public static void main(String[] args) {

        int number = 45678;

        int count = countDigits(number);

        System.out.println("Number of digits in " + number + " is: " + count);

    }
}
