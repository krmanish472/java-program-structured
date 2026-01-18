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
 *
 * Core Rule of Thumb (Memorize This)
 * Use <= when the middle element still needs to be processed.
 * Use < when pairs are processed together and the middle does NOT need special handling.
 */

/**
 * 🧠 General 2-Pointer Patterns (Interview Gold)
 * 1️⃣ Processing Every Element Once
 * Examples:
 * Squares of Sorted Array
 * Move Zeroes
 * Remove Duplicates
 * ➡️ Condition: while (left <= right) or single pointer loop
 * Reason:
 * Every element must be handled, including the middle one

 * 2️⃣ Processing Pairs of Elements
 * Examples:
 * Container With Most Water
 * Two Sum II
 * Palindrome Check
 * ➡️ Condition: while (left < right)
 * Reason:
 * When pointers meet, no valid pair remains

 * 3️⃣ Search / Matching Problems
 * Examples:
 * Two Sum II
 * Valid Palindrome
 * ➡️ Condition: while (left < right)
 * Reason:
 * You compare two distinct indices

 * 4️⃣ Partition / Rearrangement Problems
 * Examples:
 * Sort Colors
 * Partition Labels
 * Dutch National Flag
 * ➡️ Depends on whether mid needs processing
 * Often <= when mid is meaningful
 */
