package LeetCode.TwoPointer.Medium;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 5, 3};

        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;

        // find pivot element => nums[i] < nums[i+1]
        // pivot element is the element that is less than the next right element
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // if pivot exists, find next greater element than pivot on right and swap those
        if (pivot >= 0) {
            int nextGreaterIdx = n - 1;
            while (nums[nextGreaterIdx] <= nums[pivot]) {
                nextGreaterIdx--;
            }
            swap(nums, pivot, nextGreaterIdx);
        }

        // once we have the pivot and nextGreater element swapped, reverse elements after pivot till end
        reverse(nums, pivot + 1, n - 1); // => [1, 2, 5, 6, 4, 3]
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    private static void reverse(int[] nums, int leftPtr, int rightPtr) {
        while (leftPtr < rightPtr) {
            swap(nums, leftPtr, rightPtr);

            leftPtr++;
            rightPtr--;
        }
    }
}

/**
 * 👉 in array [1, 2, 4, 6, 5, 3], we get pivot as 4 and notice that elements after that...
 * 653 are in decreasing order meaning it is already the largest possible value [technically, 4653 is also the largest possible value starting at 4]
 * next permutation will be 12 followed by next number greater than 4 i.e. 5 => 125 and remaining elements in ascending order => 125346
 *
 * 🍕 if no elements exists such that it is less than the next right element, array is already in descending order
 * next permutation is the smallest (reverse whole array)
 */
