package Helper;

import java.util.Arrays;

public class SegregateZeroesAndOnes {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1};
        segregateZeroesAndOne(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void segregateZeroesAndOne(int[] arr) {
        int leftPtr = 0;
        int rightPtr = arr.length - 1;

        while (leftPtr < rightPtr) {
            while (leftPtr < rightPtr && arr[leftPtr] == 0) {
                leftPtr++;
            }
            while (leftPtr < rightPtr && arr[rightPtr] == 1) {
                rightPtr--;
            }
            swap(arr, leftPtr, rightPtr);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}