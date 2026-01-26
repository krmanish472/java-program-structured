package Integers;

public class FactorialTrailingZero {
    public static void main(String[] args) {
        int n = 13;
        int res = trailingZeroes(n);
        System.out.println(res);
    }


    public static int trailingZeroes(int n) {
        int count = 0;
        int currPowOfFive = 5;

        while (n >= currPowOfFive) {
            count += n / currPowOfFive;
            currPowOfFive *= 5;
        }

        return count;
    }

    // Note: this gives only 0s at last... we need to count all zeroes in factorial
    public static int trailingZeroes_bf(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        System.out.println(fact);

        int trailingZeroCount = 0;
        while (fact % 10 == 0) {
            trailingZeroCount++;
            fact /= 10;
        }


        return trailingZeroCount;

    }
}
