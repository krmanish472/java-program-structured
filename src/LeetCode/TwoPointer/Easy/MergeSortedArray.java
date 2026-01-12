package LeetCode.TwoPointer.Easy;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {4, 5, 6};
        int m = 3, n = 3;

        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIdx = m - 1;
        int nIdx = n - 1;

        int idx = nums1.length - 1;

        while (mIdx >= 0 && nIdx >= 0) {
            if (nums1[mIdx] > nums2[nIdx]) {
                nums1[idx--] = nums1[mIdx--];
            } else {
                nums1[idx--] = nums2[nIdx--];
            }
        }

        // copy remaining nums2 elements if any
        while (nIdx >= 0) {
            nums1[idx--] = nums2[nIdx--];
        }
    }
}

/**
 * nums1 has m elements filled and n elements as 0
 * so start filling elements from back of nums1
 *
 * Mental Rule to Remember -- Copy leftovers only from the array that does NOT own the destination buffer.
 * Note:
 * nums1 = [4,5,6,0,0,0], m = 3
 * nums2 = [1,2,3],       n = 3
 * Result: [1,2,3,4,5,6]
 * Here nums1 elements were overwritten, but only because nums2 had smaller values — once nums2 is exhausted, nums1 is already correct.
 */
