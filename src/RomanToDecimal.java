package src;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem URL: https://practice.geeksforgeeks.org/problems/roman-number-to-integer3201/1#
 */
public class RomanToDecimal {

    public static void main(String[] args) {

        final Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        String roman = "XII";

        System.out.println(toDecimal(roman, map));
    }

    private static int toDecimal(String roman, Map<Character, Integer> map) {

        int num = 0;

        int len = roman.length();
        for (int i = 0; i < len; i++) {
            if (i < len - 1 && map.get(roman.charAt(i)) < map.get(roman.charAt(i + 1))) {
                num -= map.get(roman.charAt(i));
            } else {
                num += map.get(roman.charAt(i));
            }
        }

        return num;
    }

}
