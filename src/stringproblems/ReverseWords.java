package src.stringproblems;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWords {

    public String reverseWords(String s) {
        s = s.trim().replaceAll(" +", " ");
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]).append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }
}
