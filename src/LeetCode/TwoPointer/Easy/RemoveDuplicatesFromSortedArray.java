package LeetCode.TwoPointer.Easy;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 1, 2, 2, 3, 3, 4};

        int count = removeDuplicates(nums);
        System.out.println(count);
    }

    public static int removeDuplicates(int[] nums) {
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[idx++] = nums[i]; // add first element

            // skip duplicates - keep moving until unique is encountered
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return idx;
    }
}

/**
 * idx is returned in 0 based index as idx++ is already done in every assignment
 */
