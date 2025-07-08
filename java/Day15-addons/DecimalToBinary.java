public class DecimalToBinary {

    // Recursive function to convert decimal to binary
    public static String toBinary(int n) {

        // Base case: 0 or 1
        if (n == 0) {
            return "";
        }

        // Recursive call: divide by 2 and append remainder
        return toBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        int number = 13;

        // Handle the special case when number is 0
        String binary = (number == 0) ? "0" : toBinary(number);

        System.out.println("Decimal: " + number);

        System.out.println("Binary: " + binary);

    }
}
