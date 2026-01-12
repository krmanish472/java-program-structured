package LeetCode.TwoPointer.Medium;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 7, 11, 15};
        int target = 9;

        int[] targetIndices = twoSum(numbers, target);
        System.out.println(Arrays.toString(targetIndices));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int leftPtr = 0;
        int rightPtr = numbers.length - 1;

        while (leftPtr < rightPtr) {
            if (numbers[leftPtr] + numbers[rightPtr] > target) {
                rightPtr--;
            } else if (numbers[leftPtr] + numbers[rightPtr] < target) {
                leftPtr++;
            } else {
                return new int[]{leftPtr + 1, rightPtr + 1};
            }
        }

        return new int[]{};
    }
}
