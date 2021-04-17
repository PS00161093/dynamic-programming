package src;

import static java.util.Arrays.sort;

/**
 * Problem URL: https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1#
 */
public class PossibleMaxNumber {

    public static void main(String[] args) {

        String[] arr = {"3", "30", "34", "5", "9"};

        System.out.println(printLargest(arr));

    }

    static String printLargest(String[] arr) {

        sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);

        return sb.toString();
    }

}
