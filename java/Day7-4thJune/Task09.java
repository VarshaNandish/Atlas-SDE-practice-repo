import java.util.Scanner;
public class Task09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking input from user
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int num3 = sc.nextInt();

        // Checking which number is greatest
        if (num1 > num2 && num1 > num3) {
            System.out.println(num1 + " is the greatest");
        } else if (num2 > num1 && num2 > num3) {
            System.out.println(num2 + " is the greatest");
        } else if (num3 > num1 && num3 > num2) {
            System.out.println(num3 + " is the greatest");
        } else {
            System.out.println("Two or more numbers are equal and greatest");
        }

        sc.close();
    }
}
