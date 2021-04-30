package src.stringproblems.hard;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Problem URL: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestUniqueSubString {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }

    public static int lengthOfLongestSubstring(String s) {

        int maxSize = 0;

        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String ch = s.charAt(i) + "";
            if (map.containsKey(ch)) removeTillRepeatingCharacter(map, ch);
            else map.put(ch, 1);
            if (maxSize < map.size()) maxSize = map.size();
        }

        return maxSize;
    }

    private static void removeTillRepeatingCharacter(Map<String, Integer> map, String charToRemoveTill) {

        Iterator<Map.Entry<String, Integer>> i = map.entrySet().iterator();
        while (i.hasNext()) {
            if (!i.next().getKey().equals(charToRemoveTill)) i.remove();
            else break;
        }

        i.remove();

        map.put(charToRemoveTill, 1);
    }
}
