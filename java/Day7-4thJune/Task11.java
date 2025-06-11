import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Predefined login credentials
        String correctId = "admin";
        String correctPwd = "1234";

        String inputId, inputPwd;

        while (true) {
            System.out.print("Enter Login ID: ");
            inputId = sc.nextLine();

            System.out.print("Enter Password: ");
            inputPwd = sc.nextLine();

            if (inputId.equals(correctId) && inputPwd.equals(correctPwd)) {
                System.out.println("Login successful!");
                break;
            } else {
                System.out.println("Invalid ID or password. Please try again.\n");
            }
        }

        sc.close();
    }
}
