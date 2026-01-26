package Integers;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};

        int res = singleNumber(nums);
        System.out.println(res);
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums){
            res = res ^ num;
        }
        return res;
    }
}
