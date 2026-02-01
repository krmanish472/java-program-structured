package Arrays;

public class FindMissingPositive {
    public static void main(String[] args) {
        int[] nums = {4, -1, 1, 8, -5, 11, 3, 0};

        int missingPos = firstMissingPositive(nums);
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // mark 0 and -ve number as n+1 -> as those are not required, we need positive only
        // and making n+1, will never interfere with other indices
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        // mark element visited as -ve
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (idx < n && nums[idx] > 0) { // add idx < n as for n+1 index, idx = n, which is out of bound
                nums[idx] *= -1;
            }
        }

        // loop to find positive value left
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }

        return n + 1;  // 1 2 3 4 5 for this the missing positive is 6
    }
}
