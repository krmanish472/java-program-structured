package Helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckArrayEquals {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 3};
        int[] nums2 = {1, 2, 3, 4};

        // Use for Same order
        boolean res = Arrays.equals(nums1, nums2);
        System.out.println(res); // => false

        // Use for Any order
        boolean res1 = isArrayEquals(nums1, nums2);
        System.out.println(res1); // => true
    }

    public static boolean isArrayEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : arr2) {
            if (!freq.containsKey(num)) {
                return false;
            }

            freq.put(num, freq.get(num) - 1);
            if (freq.get(num) == 0) {
                freq.remove(num);
            }
        }

        return freq.isEmpty();
    }
}
