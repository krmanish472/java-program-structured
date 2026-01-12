package LeetCode.TwoPointer.Easy;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        } // post this loop, idx = 3

        // from idx (3), keep filling the array with zero
        while (idx < nums.length) {
            nums[idx++] = 0;
        }

    }
}

/**
 * Gotcha - we need to move zeroes to end -
 * i.e. we just need to track all non-zero elements and keep adding it to array, rest all will be zeroes
 */
