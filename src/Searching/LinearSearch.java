package Searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {4, 7, 2, 8, 9, 3};
        int idx = linearSearch(arr, 8);
        System.out.println(idx);
    }

    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) return i;
        }
        return -1;
    }
}
