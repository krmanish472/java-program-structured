package Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 5};
        int[] nums1 = {2, 1, 0, 3, 1, 1, 5};

        boolean canJump = canJump(nums);
        System.out.println(canJump);

        boolean canJump1 = canJump(nums1);
        System.out.println(canJump1);
    }


    public static boolean canJump(int[] nums) {
        int targetIdx = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= targetIdx) {
                targetIdx = i;
            }
        }

        return targetIdx == 0;
    }
}

/**
 * Greedy Approach - start with last index
 * If jump is possible from prev idx to last index, update last index to prev idx and check if it is possible to jump there
 * If jump is possible, that means target idx will move to 0th idx
 */
