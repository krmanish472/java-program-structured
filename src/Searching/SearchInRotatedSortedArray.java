package Searching;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 0, 1, 2, 3, 4, 5, 6};
        int target = 8;

        int idx = search(nums, target);
        System.out.println(idx);
    }

    // 7, 8, 9, 0, 1, 2, 3, 4, 5, 6
    public static int search(int[] nums, int target) {
        int leftPtr = 0;
        int rightPtr = nums.length - 1;

        while (leftPtr <= rightPtr) {
            int mid = leftPtr + (rightPtr - leftPtr) / 2;
            if (target == nums[mid]) return mid;

            if (nums[leftPtr] <= nums[mid]) { // left half is sorted
                // key is in left half
                if (nums[leftPtr] <= target && target < nums[mid]) {
                    rightPtr = mid - 1;
                } else {
                    leftPtr = mid + 1;
                }
            } else { // right half is sorted
                // key is in right half
                if (nums[mid] < target && target <= nums[rightPtr]) {
                    leftPtr = mid + 1;
                } else {
                    rightPtr = mid - 1;
                }
            }
        }

        return -1;
    }

}

/**
 * When an array is Rotated-Sorted, we will have 2 parts, which will be self sorted
 * Ex - [4, 5, 6, 7, 0, 1, 2] leftSorted => [4,5,6,7] and rightSorted => [0,1,2]
 * Note that THE ELEMENT from where the division occurs, has a particular property ---
 * --- the pivot element is less than prev element as well as next element
 */
