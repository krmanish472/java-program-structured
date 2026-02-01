package String;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s1 = "BABAD";
        String s2 = "ABBA";

        String res1 = longestPalindrome(s1);
        String res2 = longestPalindrome(s2);
        System.out.println(res1);
        System.out.println(res2);
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        String longestPalindromicSubstring = "";
        for (int i = 1; i < s.length(); i++) {
            // consider odd length => BABAD
            int leftPtr = i;
            int rightPtr = i;

            while (leftPtr >= 0 && rightPtr < s.length() && s.charAt(leftPtr) == s.charAt(rightPtr)) {
                leftPtr--;
                rightPtr++;
            }

            String currSubstring = s.substring(leftPtr + 1, rightPtr);
            if (currSubstring.length() > longestPalindromicSubstring.length()) {
                longestPalindromicSubstring = currSubstring;
            }

            // consider even length => ABBA
            leftPtr = i - 1;
            rightPtr = i;

            while (leftPtr >= 0 && rightPtr < s.length() && s.charAt(leftPtr) == s.charAt(rightPtr)) {
                leftPtr--;
                rightPtr++;
            }
            currSubstring = s.substring(leftPtr + 1, rightPtr);
            if (currSubstring.length() > longestPalindromicSubstring.length()) {
                longestPalindromicSubstring = currSubstring;
            }
        }

        return longestPalindromicSubstring;
    }
}
