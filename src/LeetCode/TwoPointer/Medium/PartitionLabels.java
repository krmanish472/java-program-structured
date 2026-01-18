package LeetCode.TwoPointer.Medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";

        List<Integer> res = partitionLabels_alt(s);
        System.out.println(res);
    }

    public static List<Integer> partitionLabels(String str) {
        List<Integer> partitions = new ArrayList<>();

        int startIdx = 0;
        while (startIdx < str.length()) {
            int endIdx = str.lastIndexOf(str.charAt(startIdx));

            // loop through in-between characters of selected partition and update end index
            for (int i = startIdx + 1; i <= endIdx - 1; i++) {
                endIdx = Math.max(endIdx, str.lastIndexOf(str.charAt(i)));
            }

            partitions.add(endIdx - startIdx + 1);
            startIdx = endIdx + 1; // update start index to next char
        }

        return partitions;
    }

    public static List<Integer> partitionLabels_alt(String str) {
        List<Integer> partitions = new ArrayList<>();

        int[] lastIdx = new int[26];
        for (int i = 0; i < str.length(); i++) {
            lastIdx[str.charAt(i) - 'a'] = i;
        }

        int startIdx = 0;
        int endIdx = 0;

        for (int idx = 0; idx < str.length(); idx++) {
            endIdx = Math.max(endIdx, lastIdx[str.charAt(idx) - 'a']);

            // if idx pointer comes to meet end-index, there is nothing more than can be added to the string
            if (idx == endIdx) {
                partitions.add(endIdx - startIdx + 1);
                startIdx = endIdx + 1;
            }
        }

        return partitions;
    }
}

/**
 * Consider this as the partition -- ...hijhklijpq...
 * start index is 0, end index is 3
 * in-between chars [i,j] -- get last index, if last index is greater than current endIdx, update endIndex
 * once all chars are covered, add length in partition list
 */
