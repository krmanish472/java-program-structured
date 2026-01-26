package Integers;

public class PowXN {
    public static void main(String[] args) {
        double res = myPow(2, 10);
        System.out.println(res);
    }

    // 2^10 => 2^5*2
    // 4^5 => (4)*4^4 => 4*16^2 => 4*256^1 => 4*256
    public static double myPow(double x, int n) {
        long num = Math.abs((long) n);
        double res = 1.0;

        while (num != 0) {
            if (num % 2 == 0) {
                x = x * x;
                num = num / 2;
            } else {
                res = res * x;
                num = num - 1;
            }
        }

        return n < 0 ? 1.0 / res : res;
    }
}
