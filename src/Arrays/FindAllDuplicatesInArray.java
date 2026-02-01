package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] *= -1; // mark visited by making -ve
            } else { // if element is -ve, we have already visited this
                duplicates.add(idx + 1); // duplicate is the value that should have been here, +1 for 0-based index
            }
        }

        return duplicates;
    }
}

/**
 * when given an array of length n that has elements 1 to n
 * if n = 5, arr = [1,2,3,4,5] or [1,4,5,2,3] we can consider elements as index [but 0-based]
 * so, for each idx = 0, value should be 1, for idx = 1, value should be 2
 */
