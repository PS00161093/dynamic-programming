package src.stringproblems;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MaxSubString {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("au"));
    }

    public static int lengthOfLongestSubstring(String s) {


        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int len = 0;
        TreeSet<Integer> cnt = new TreeSet<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            for (int j = i; j < s.length(); j++) {
                char c1 = s.charAt(j);
                if (!set.contains(c1)) {
                    set.add(c1);
                    len = len + 1;
                } else {
                    cnt.add(len);
                    set.clear();
                    len = 0;
                    break;
                }
            }
        }

        return cnt.isEmpty() ? 0 : cnt.last();
    }
}

