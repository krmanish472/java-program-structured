package LeetCode.TwoPointer.Medium;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};

        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
    }

    public static int findDuplicate(int[] nums) {
        int slowPtr = 0;
        int fastPtr = 0;

        do {
            slowPtr = nums[slowPtr];
            fastPtr = nums[nums[fastPtr]];
        }
        while (slowPtr != fastPtr); // on loop completion, pointers meet

        // as soon as they meet - move head/fastPtr to start
        // and move both at same speed
        fastPtr = 0;
        while (slowPtr != fastPtr) {
            slowPtr = nums[slowPtr];
            fastPtr = nums[fastPtr];
        }
        return fastPtr;
    }

}

/**
 * We use do-while because the slow and fast pointers must move at least once before we compare them.
 * If we used while, the loop would terminate immediately since both pointers start at the same position.
 */
