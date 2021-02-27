package src.stringproblems;

public class ReduceString {

    public static void main(String[] args) {
        String input = "abaa";
        String left = input.substring(0, input.length() / 2);
        String right = input.substring(input.length() / 2);

        String rotated = right + left;
        left = rotated.substring(0, rotated.length() / 2);
        right = rotated.substring(rotated.length() / 2);

        char lc = left.charAt(left.length() - 1);
        char rc = right.charAt(0);

        while (lc == rc) {
            int a = 0;
            for (int i = left.length() - 1; i >= 0; i--) {
                if (lc == left.charAt(i)) a++;
                else break;
            }
            left = left.substring(0, left.length() - a);

            a = 0;
            for (int i = 0; i < right.length(); i++) {
                if (rc == right.charAt(i)) a++;
                else break;
            }
            right = right.substring(a);

            if (left.length() - 1 >= 0) lc = left.charAt(left.length() - 1);
            if (right.length() != 0) rc = right.charAt(0);
        }

        System.out.println(left + right);
    }
}
