package String;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);

        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        int leftPtr = 0;
        int rightPtr = s.length - 1;

        while (leftPtr < rightPtr) {
            char temp = s[leftPtr];
            s[leftPtr] = s[rightPtr];
            s[rightPtr] = temp;

            leftPtr++;
            rightPtr--;
        }
    }
}
