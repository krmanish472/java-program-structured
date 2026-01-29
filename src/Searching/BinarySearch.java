package Searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 6;

        int idx = binarySearch(arr, target);
        System.out.println(idx);
    }

    private static int binarySearch(int[] arr, int target) {
        int leftPtr = 0;
        int rightPtr = arr.length - 1;

        while (leftPtr <= rightPtr) {
            int mid = leftPtr + (rightPtr - leftPtr) / 2;
            if (target == arr[mid]) return mid;
            if (target > arr[mid]) {
                leftPtr = mid + 1;
            } else {
                rightPtr = mid - 1;
            }
        }

        return -1;
    }
}


/**
 * In Java, int has a max value:
 * Integer.MAX_VALUE = 2,147,483,647
 * <p>
 * If left and right are large, this can overflow.
 * <p>
 * Example
 * int left = 1_800_000_000;
 * int right = 2_000_000_000;
 * <p>
 * int mid = (left + right) / 2; // ❌ overflow
 * <p>
 * What happens?
 * left + right = 3,800,000,000  // exceeds int limit
 */