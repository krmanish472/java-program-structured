package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        List<String> res = findRepeatedDnaSequences(s);
        System.out.println(res);
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String subStr = s.substring(i, i + 10);
            if (set.contains(subStr) && !list.contains(subStr)) { // more than 1 is found, add to list
                list.add(subStr);
            }
            set.add(subStr);
        }

        return list;
    }

    /**
     * Note: we can use HashMap as well
     */
}
