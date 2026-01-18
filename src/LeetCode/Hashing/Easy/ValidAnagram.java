package LeetCode.Hashing.Easy;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";

        boolean res = isAnagram(s, t);
        System.out.println(res);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        // if strings are anagram, charCount array will have all elements 0;
        for (int c : charCount) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}

/**
 * 🧠 Rule of Thumb
 * Characters	Array-size	Use
 * 'a'–'z'	26	c - 'a'
 * 'A'–'Z'	26	c - 'A'
 * '0'–'9'	10	c - '0'
 */

/**
 * “Why do we subtract 'a'?”
 * “To convert a character into a zero-based index relative to the alphabet.”
 */
