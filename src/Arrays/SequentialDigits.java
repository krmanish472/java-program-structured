package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        int low = 1000, high = 13000;

        List<Integer> res = sequentialDigits(low, high);
        System.out.println(res);
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        String str = "123456789";
        List<Integer> list = new ArrayList<>();

        int lowLen = String.valueOf(low).length(); // 4
        int highLen = String.valueOf(high).length(); // 5

        // get substring of length 4 - 1234, 2345,...
        // get substring of length 5 - 12345, 23456,...
        for (int len = lowLen; len <= highLen; len++) {
            for (int idx = 0; idx + len <= str.length(); idx++) {
                String seq = str.substring(idx, idx + len);
                int value = Integer.parseInt(seq);
                if (value >= low && value <= high) {
                    list.add(value);
                }
            }
        }

        return list;
    }
}
