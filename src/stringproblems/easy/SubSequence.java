package src.stringproblems.easy;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class SubSequence {

    public static boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;
        for (char c : s.toCharArray()) {
            int idx = t.indexOf(c);
            if (idx == -1) return false;
            t = t.substring(idx + 1);
        }
        return true;
    }
}
