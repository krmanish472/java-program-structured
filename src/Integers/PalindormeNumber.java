package Integers;

public class PalindormeNumber {
    public static void main(String[] args) {
        int x = 121;

        boolean isPalindrome = isPalindrome(x);
        System.out.println(isPalindrome);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int rev = 0;
        int num = x;
        while (x != 0) {
            int lastDigit = x % 10;
            rev = rev * 10 + lastDigit;
            x /= 10;
        }

        return rev == num;
    }
}
