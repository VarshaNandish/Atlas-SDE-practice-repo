public class PalindromeChecker {

    // Recursive function to check if a string is a palindrome
    public static boolean isPalindrome(String str, int start, int end) {

        // Base case: if the pointers cross or are equal, it's a palindrome
        if (start >= end) {
            return true;
        }

        // If characters at start and end don't match, it's not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive step: move inward
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String input = "madam";

        boolean result = isPalindrome(input, 0, input.length() - 1);

        if (result) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");

        }
    }
}