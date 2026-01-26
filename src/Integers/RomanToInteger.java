package Integers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";

        int val = romanToInt(s);
        System.out.println(val);
    }

    // MCMXCIV => 1000+900+90+4
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        /**
         for (int i = 0; i < s.length() - 1; i++) {
         if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
         res -= map.get(s.charAt(i));
         } else {
         res += map.get(s.charAt(i));
         }
         }

         return res + map.get(s.charAt(s.length() - 1));
         **/

        for (int i = 0; i < s.length(); i++) { // loop through all chars
            // skip last char => only check for 0 to 5 chars
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }

        return res;
    }
}
