import java.util.Scanner;

public class DisplayDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a 5-digit number: ");
        int number = sc.nextInt();

        if (number < 10000 || number > 99999) {
            System.out.println("Invalid input! Please enter exactly a 5-digit number.");
            return;
        }

        int units = number % 10;
        int tens = (number / 10) % 10;
        int hundreds = (number / 100) % 10;
        int thousands = (number / 1000) % 10;
        int tenThousands = (number / 10000);

        System.out.println("Units digit is: " + units);
        System.out.println("Ones digit is: " + tens);
        System.out.println("Hundreds digit is: " + hundreds);
        System.out.println("Thousands digit is: " + thousands);
        System.out.println("10 Thousands digit is: " + tenThousands);
    }
}
