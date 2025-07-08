public class ReverseStringRecursive {

    // Recursive function to reverse a char array
    public static void reverseCharArray(char[] str, int start, int end) {

        // Base case: pointers meet or cross
        if (start >= end) {
            return;
        }

        // Swap characters at start and end
        char temp = str[start];
        str[start] = str[end];
        str[end] = temp;

        // Recur for the rest
        reverseCharArray(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String input = "hello";

        // Convert String to char array
        char[] charArray = input.toCharArray();

        // Call recursive function
        reverseCharArray(charArray, 0, charArray.length - 1);

        // Convert char array back to string
        String reversed = new String(charArray);

        System.out.println("Original string: " + input);

        System.out.println("Reversed string: " + reversed);

    }
}

