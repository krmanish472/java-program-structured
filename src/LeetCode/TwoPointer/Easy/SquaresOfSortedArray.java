package LeetCode.TwoPointer.Easy;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-7, -4, 2, 3, 5};

        int[] result = sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sortedSquares(int[] nums) {
        int leftPtr = 0;
        int rightPtr = nums.length - 1;

        int[] result = new int[nums.length];
        int idx = nums.length - 1;

        while (leftPtr <= rightPtr) {
            int leftSq = nums[leftPtr] * nums[leftPtr];
            int rightSq = nums[rightPtr] * nums[rightPtr];

            // on every pass, check for the largest of 2
            if (leftSq > rightSq) {
                result[idx--] = leftSq;
                leftPtr++;
            } else {
                result[idx--] = rightSq;
                rightPtr--;
            }
        }

        return result;
    }
}

/**
 * use 2 pointers, on each pass, square and check for the greater one and add greater one at last pos (idx) of new array
 * once added the greater one, move the added pointer ahead to check if next squared element at same ptr is greater, and vice versa
 */
