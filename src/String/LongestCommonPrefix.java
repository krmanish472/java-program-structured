package String;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        String res = longestCommonPrefix(strs);
        System.out.println(res);
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

    public static String longestCommonPrefix_withSorting(String[] strs) {
        StringBuilder prefix = new StringBuilder();

        Arrays.sort(strs);

        String firstWord = strs[0];
        String lastWord = strs[strs.length - 1];
        for (int i = 0; i < firstWord.length(); i++) {
            if (firstWord.charAt(i) != lastWord.charAt(i)) {
                break;
            }
            prefix.append(firstWord.charAt(i));
        }

        return prefix.toString();
    }
}
