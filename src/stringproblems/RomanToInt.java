package src.stringproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem URL: https://leetcode.com/problems/roman-to-integer/
 * 3999 / 3999 test cases passe
 */
public class RomanToInt {

    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV")); // 1994
    }

    static int romanToInt(String s) {

        int num = 0;

        if (s.length() == 1) return map.get(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {

            int curVal = map.get(s.charAt(i));
            int prev = i - 1 >= 0 ? map.get(s.charAt(i - 1)) : 0;

            if (prev != 0 && prev < curVal) num = num + curVal - (2 * prev);
            else num += curVal;
        }

        return num;

    }

    static {

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

    }
}
