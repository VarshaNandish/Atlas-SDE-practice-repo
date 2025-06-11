import java.util.Scanner;
public class Task06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your ID: ");
        String id = sc.nextLine();

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        System.out.println("\nHi,");
        System.out.println("Your login ID is " + id);
        System.out.println("And your password is " + password);
    }
}
