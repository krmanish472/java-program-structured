package LeetCode.TwoPointer.Easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        boolean isPalindrome = isPalindrome(s);
        System.out.println(isPalindrome);
    }

    public static boolean isPalindrome(String s) {
        int leftPtr = 0;
        int rightPtr = s.length() - 1;

        while (leftPtr < rightPtr) {
            while (leftPtr < rightPtr && !Character.isLetterOrDigit(s.charAt(leftPtr))) {
                leftPtr++;
            }
            while (leftPtr < rightPtr && !Character.isLetterOrDigit(s.charAt(rightPtr))) {
                rightPtr--;
            }

            if (Character.toUpperCase(s.charAt(leftPtr)) != Character.toUpperCase(s.charAt(rightPtr))) {
                return false;
            }

            leftPtr++;
            rightPtr--;
        }

        return true;
    }
}


/**
 * inner while is required to make sure if there are more than one non-letter or non-digit, it considers all of those -- "man, a"
 * also, if string is ".,", inner while will keep running, need leftPtr < rightPtr condition to stop
 * Note:
 * Simplest two-pointer logic
 * Teaches skipping characters + pointer convergence
 */