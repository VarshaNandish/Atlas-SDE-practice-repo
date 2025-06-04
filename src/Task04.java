public class Task04 {

    // Method to add two numbers

    public static int add(int a, int b) {
        return a + b;
    }

    // Method to subtract two numbers
    public static int subtract(int a, int b) {
        return a - b;
    }

    // Method to multiply two numbers
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Method to divide two numbers
    public static int divide(int a, int b) {
        return a / b;
    }

    //Main method

    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        System.out.println("Main started");

        System.out.println("Sum of 2 numbers is " + add(a, b));

        System.out.println("Diff of 2 numbers is " + subtract(a, b));

        System.out.println("Product of 2 numbers is " + multiply(a, b));

        System.out.println("Division of 2 numbers is " + divide(a, b));

        System.out.println("Main ended");

    }

}
