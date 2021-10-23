package src.easy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueChar {

    public int firstUniqChar(String s) {

        int[] count = new int[26];
        int len = s.length();

        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            count[index] = count[index] + 1;
        }

        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) return i;
        }

        return -1;
    }

    public int firstUniqChar1(String s) {
        int len = s.length();
        if (len == 1) return 0;
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) return s.indexOf(e.getKey());
        }

        return -1;
    }
}
