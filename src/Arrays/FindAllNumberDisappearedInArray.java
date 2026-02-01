package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumberDisappearedInArray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> disappearedNums = findDisappearedNumbers(nums);
        System.out.println(disappearedNums);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNums = new ArrayList<>();

        // mark visited elements as -ve
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        // if any number is left positive, it's index didn't find the corresponding value i.e i+1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                disappearedNums.add(i + 1);
            }
        }

        return disappearedNums;
    }
}

/**
 * when given an array of length n that has elements 1 to n
 * if n = 5, arr = [1,2,3,4,5] or [1,4,5,2,3] we can consider each element as index [but 0-based]
 * so, for idx = 0, value should be 1, for idx = 1, value should be 2 => i+1
 */
