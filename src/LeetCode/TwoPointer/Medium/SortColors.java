package LeetCode.TwoPointer.Medium;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);

        System.out.println(Arrays.toString(nums)); // => [0, 0, 1, 1, 2, 2]
    }

    public static void sortColors(int[] nums) {
        int leftPtr = 0;
        int midPtr = 0;
        int rightPtr = nums.length - 1;

        while (midPtr <= rightPtr) {
            switch (nums[midPtr]) {
                case 0: // => [1, 0, 2, 1, 2, 0]
                    swap(nums, midPtr, leftPtr);
                    leftPtr++;
                    midPtr++;
                    break;
                case 1:
                    midPtr++;
                    break;
                case 2: // => [2, 0, 2, 1, 1, 1]
                    swap(nums, midPtr, rightPtr);
                    rightPtr--;
                    break;
            }
        }
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}

/**
 * when swapping for '2', make mid is not moved as for ex - [2, 0, 2, 1, 1, 1]
 * if we swap 2 with 1, => [1, 0, 2, 1, 1, 2], 2 is at correct pos so move right backward
 * BUT on swap, when 1 moved to start pos... it's not the correct pos, so moving mid++ will cause issue as that element later needs to move to middle
 */

/**
 * when swapping for '1', make mid is not moved as for ex - [1, 0, 2, 1, 2, 0]
 * if we swap 1 with 0, => [0, 0, 2, 1, 1, 1], 0 is at correct pos so move left forward
 * ALOS on swap, when 1 moved to last pos... even though it's not the correct pos, mid should change its position as left and mid started at same place...
 * and as left is in correct pos, mid should look for next element in array
 */
