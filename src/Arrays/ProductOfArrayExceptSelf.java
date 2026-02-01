package Arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int[] product = productExceptSelf(nums);
        System.out.println(Arrays.toString(product));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] productArr = new int[nums.length];

        productArr[0] = 1; // prefixProductArray
        for (int i = 1; i < nums.length; i++) {
            productArr[i] = nums[i - 1] * productArr[i - 1];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            productArr[i] = productArr[i] * suffix;
            suffix *= nums[i];
        }

        return productArr;
    }
}

/**
 * prefixProductArr = [1, 1, 2, 6]
 * suffixProductArr = [24, 12, 4, 1]
 */
