public class DigitSummer {

    // Recursive function to sum digits
    public static int sumDigits(int num) {

        // Base case: when number is 0
        if (num == 0) {
            return 0;
        }

        // Recursive step: add last digit and recurse on the rest
        return (num % 10) + sumDigits(num / 10);
    }

    public static void main(String[] args) {

        int number = 45678;

        int sum = sumDigits(number);

        System.out.println("Sum of digits in " + number + " is: " + sum);

    }
}