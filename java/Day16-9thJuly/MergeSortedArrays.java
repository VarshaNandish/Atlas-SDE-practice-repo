public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 6, 8};
        int[] arr2 = {2, 3, 5, 7, 9};

        int[] merged = merge(arr1, arr2);

        System.out.print("Merged array: ");
        for (int num : merged) {
            System.out.print(num + " ");
        }
    }

    public static int[] merge(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[] result = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (a[i] < b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < n) {
            result[k++] = a[i++];
        }

        while (j < m) {
            result[k++] = b[j++];
        }

        return result;
    }
}
