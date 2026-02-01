package Arrays;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "abc", magazine = "abcd";
        String ransomNote1 = "aabc", magazine1 = "abcd";

        boolean canConstruct = canConstruct(ransomNote, magazine);
        System.out.println(canConstruct);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] freqCount = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            freqCount[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (freqCount[ransomNote.charAt(i) - 'a'] >= 1) {
                freqCount[ransomNote.charAt(i) - 'a']--;
            } else {
                return false;
            }
        }

        return true;
    }

}
