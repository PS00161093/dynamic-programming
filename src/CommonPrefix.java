package src;

public class CommonPrefix {

    public static void main(String[] args) {

        String[] arr = {"flower", "flower", "flower", "flower"};
        System.out.println(longestCommonPrefix(arr));
    }

    public static String longestCommonPrefix(String[] strs) {

        String result = "";
        if (strs.length == 0) return result;
        String firstWord = strs[0];
        if (firstWord.equals("") || firstWord.equals(" ")) return result;

        int index = 0;
        String p = String.valueOf(firstWord.charAt(index));
        while (check(strs, p)) {
            result = p;
            index = index + 1;
            if (firstWord.length() == 1) break;
            else if (index >= 0 && index <= firstWord.length()) {
                p = firstWord.substring(0, index);
            } else {
                break;
            }
        }

        return result;
    }

    public static boolean check(String[] strs, String p) {

        for (String s : strs)
            if (!s.startsWith(p))
                return false;

        return true;
    }
}
