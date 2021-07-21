package src.stringproblems.easy;

/**
 * Problem URL: https://leetcode.com/problems/implement-strstr/
 */
public class SubStringIndex {

    public static void main(String[] args) {
        System.out.println(getIndex("mississippi", "issip"));
    }

    public static int getIndex(String hayStack, String needle) {
        int needleLen = needle.length();
        if (needleLen == 0) return 0;

        int hayStackLen = hayStack.length();
        if (hayStackLen == 0) return -1;

        for (int i = 0; i < hayStackLen; i++) {
            if (i + needleLen > hayStackLen) break;
            for (int j = 0; j < needleLen; j++) {
                if (hayStack.charAt(i + j) != needle.charAt(j)) break;
                if (j == needleLen - 1) return i;
            }
        }

        return -1;
    }

}