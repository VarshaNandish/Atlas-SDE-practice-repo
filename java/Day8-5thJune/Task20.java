public class Task20 {
    public static void main(String[] args) {
        // initializing the char array
        char[] Name = {'V', 'a', 'r', 's', 'h', 'a'};

        // Print the full name as a string
        System.out.println(Name); // Java prints char[] as string

        // Get the length
        int n = Name.length;
        System.out.println("There are " + n + " letters in my name");

        // Use for loop to print each letter
        System.out.println("Each letter:");
        for (int i = 0; i < n; i++) {
            System.out.println(Name[i]);
        }
    }
}