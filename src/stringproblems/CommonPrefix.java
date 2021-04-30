package src.stringproblems;

public class CommonPrefix {

    public static void main(String[] args) {

        String[] arr = {"flower", "flower", "flower", "flowe"};
        System.out.println(longestCommonPrefix(arr));
    }

    public static String longestCommonPrefix(String[] strs) {

        String result = "";
        if (strs.length == 0) return result;
        String firstWord = strs[0];
        if (firstWord.equals("") || firstWord.equals(" ")) return result;

        int index = 0;
        String prefix = String.valueOf(firstWord.charAt(index));
        while (check(strs, prefix)) {
            result = prefix;
            index = index + 1;
            if (firstWord.length() == 1) break;
            else if (index >= 0 && index <= firstWord.length()) {
                prefix = firstWord.substring(0, index);
            } else {
                break;
            }
        }

        return result;
    }

    public static boolean check(String[] strs, String prefix) {

        for (String s : strs)
            if (!s.startsWith(prefix))
                return false;

        return true;
    }
}
