package LeetCode.TwoPointer.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> res = threeSum(nums);
        System.out.println(res); // => [[-1, -1, 2], [-1, 0, 1]]
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>(); // => [-4, -1, -1, 0, 1, 2]
        for (int i = 0; i < nums.length - 2; i++) {
            // repeated 'i's are skipped
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int leftPtr = i + 1; // leftPtr won't be 0, it starts after picked 'i'
            int rightPtr = nums.length - 1;

            while (leftPtr < rightPtr) {
                int sum = nums[i] + nums[leftPtr] + nums[rightPtr];
                if (sum > 0) {
                    rightPtr--;
                } else if (sum < 0) {
                    leftPtr++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[leftPtr], nums[rightPtr]));
                    // for same i, we can have other 2 leftPtr, rightPtr which can form 3Sum
                    // ... while considering those make sure repeated numbers are skipped
                    while (leftPtr < rightPtr && nums[leftPtr] == nums[leftPtr + 1]) {
                        leftPtr++;
                    }
                    while (leftPtr < rightPtr && nums[rightPtr] == nums[rightPtr - 1]) {
                        rightPtr--;
                    }

                    leftPtr++;
                    rightPtr--;
                }
            }
        }

        return res;
    }
}

/**
 * 🍕 WELL WELL WELL... In else, we can have same number repeated multiple time and not just duplicate so keep skipping (i.e. use while and not if)
 * but left should be less than right as well
 * Also, leftPtr++ and rightPtr-- is required, so that in [....2,2,3....5,6,6...] when in "while",
 * leftPtr++ moves from 1st 2 to 2nd 2, but we need to move after that to pick unique value
 * same for rightPtr
 *
 * Note: If we don't skip i-check, we end up with duplicate results [[-1, -1, 2], [-1, 0, 1], [-1, 0, 1]]
 */

/**
 * Interview Rule of Thumb (IMPORTANT)
 * If a pointer is controlled by the loop header → use if to skip duplicates.
 * If a pointer is manually moved inside the loop → use while to skip duplicates.
 *
 * “Because i is already controlled by the outer loop. We only need to skip one duplicate per iteration,
 * whereas left and right may need to skip multiple duplicates.”
 */
