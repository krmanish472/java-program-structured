package LeetCode.TwoPointer.Medium;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int leftPtr, int rightPtr) {
        while (leftPtr < rightPtr) {
            int temp = nums[leftPtr];
            nums[leftPtr] = nums[rightPtr];
            nums[rightPtr] = temp;

            leftPtr++;
            rightPtr--;
        }
    }
}

/**
 * “Why do we do k %= n?”
 * “Because rotating by n or any multiple of n results in the same array.
 * Taking modulo keeps k within bounds and prevents invalid indices.”
 * 👉 But rotating by
 * k = n → array stays the same
 * k = n + 1 → same as rotating by 1
 * k = 2n → same as rotating by 0
 * So rotations are cyclic with period n and only k % n rotations actually matter.
 */
