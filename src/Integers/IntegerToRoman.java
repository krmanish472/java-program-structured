package Integers;

public class IntegerToRoman {
    public static void main(String[] args) {
        int num = 3749;
        String res = intToRoman(num);
        System.out.println(res);
    }

    public static String intToRoman(int num) {
        int[] intValue = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanValue = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < romanValue.length; i++) {
            while (num != 0 && num >= intValue[i]) {
                num = num - intValue[i];
                sb.append(romanValue[i]);
            }
        }

        return sb.toString();
    }


    /**
     * Input: num = 3749
     * Output: "MMMDCCXLIX"
     * Explanation:
     * 3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
     *  700 = DCC as 500 (D) + 100 (C) + 100 (C)
     *   40 = XL as 10 (X) less of 50 (L)
     *    9 = IX as 1 (I) less of 10 (X)
     * Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
     */
}
