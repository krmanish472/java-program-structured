package Integers;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 123;

        int res = reverse(x);
        System.out.println(res);
    }

    // Given a signed 32-bit integer x, return x with its digits reversed.
    // If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            rev = rev * 10 + lastDigit;

            x /= 10;
        }
        return rev;
    }
}
