package Arrays;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        int length = lengthOfLastWord(s);
        System.out.println(length);
    }

    public static int lengthOfLastWord(String s) {
        int rightPtr = s.length() - 1;
        while (rightPtr >= 0 && s.charAt(rightPtr) == ' ') {
            rightPtr--;
        }

        int leftPtr = rightPtr;
        while (leftPtr >= 0 && s.charAt(leftPtr) != ' ') {
            leftPtr--;
        }

        return rightPtr-leftPtr;
    }


}
