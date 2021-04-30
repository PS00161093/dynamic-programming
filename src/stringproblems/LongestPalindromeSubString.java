package src.stringproblems;

import static java.lang.Math.max;

/**
 * Problem URL: https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromeSubString {

    public static void main(String[] args) {

        System.out.println(getLongestPalindromeSubString("bb"));
    }

    public static String getLongestPalindromeSubString(String s) {

        if (s == null || s.length() < 1) return "";

        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = max(expandAroundCenter(s, i, i), expandAroundCenter(s, i, i + 1));
            if (len > endIndex - startIndex) {
                startIndex = i - (len - 1) / 2;
                endIndex = i + len / 2;
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {

        int tempLeft = left;
        int tempRight = right;

        while (tempLeft >= 0 && tempRight < s.length() && s.charAt(tempLeft) == s.charAt(tempRight)) {
            tempLeft--;
            tempRight++;
        }

        return tempRight - tempLeft - 1;
    }
}
