public class RecursiveArraySearch {

    // Recursive function to search for a target element
    public static int recursiveSearch(int[] arr, int target, int index) {

        // Base case: index goes out of bounds
        if (index == arr.length) {
            return -1;
        }

        // Base case: element found
        if (arr[index] == target) {
            return index;
        }

        // Recursive step: search in the rest of the array
        return recursiveSearch(arr, target, index + 1);
    }



    public static void main(String[] args) {

        int[] nums = {5, 8, 12, 20, 30, 45};
        int target = 20;

        int result = recursiveSearch(nums, target, 0);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in array.");

        }
    }
}

