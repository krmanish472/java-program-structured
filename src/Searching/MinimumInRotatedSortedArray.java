package Searching;

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        int min = findMin(nums);
        System.out.println(min);
    }

    public static int findMin(int[] nums) {
        int leftPtr = 0;
        int rightPtr = nums.length - 1;

        while (leftPtr < rightPtr) {
            int mid = leftPtr + (rightPtr - leftPtr) / 2;

            // if mid is greater, means leftPtr to mid is in ascending order
            // i.e. element is not in that segment, so move leftPtr
            if (nums[mid] > nums[rightPtr]) {
                leftPtr = mid + 1;
            } else {
                rightPtr = mid;
            }
        }

        return nums[leftPtr];
    }

    public static int findMin_alt(int[] nums) {
        int leftPtr = 0;
        int rightPtr = nums.length - 1;

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);
        if (nums[leftPtr] < nums[rightPtr]) return nums[leftPtr];

        while (leftPtr <= rightPtr) {
            int mid = leftPtr + (rightPtr - leftPtr) / 2;

            // in a rotated sorted array, each element is less than its next element
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1]; // 7, 0
            // in a rotated sorted array, smallest/minimum element is less than prev element
            if (nums[mid] < nums[mid - 1]) return nums[mid];

            if (nums[mid] > nums[leftPtr]) {
                leftPtr = mid + 1;
            } else {
                rightPtr = mid - 1;
            }
        }

        return 0;
    }

}
