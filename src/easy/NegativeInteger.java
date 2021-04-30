package src.easy;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.copyOfRange;

/**
 * Problem URL: https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1#
 */
public class NegativeInteger {

    public static void main(String[] args) {

        long[] arr = {-8, 2, 3, -6, 10};
        int k = 2;
        System.out.println(printFirstNegativeInteger(arr, k));
    }

    public static List<Long> printFirstNegativeInteger(long[] arr, int k) {

        List<Long> result = new ArrayList<>();

        int index = 0;
        while (index <= arr.length - k) {
            long[] subArray = copyOfRange(arr, index, index + k);
            result.add(addNegativeValue(subArray));
            index++;
        }

        return result;
    }

    private static long addNegativeValue(long[] temp) {

        boolean ifFound = false;

        long theNumber = 0L;
        for (long l : temp) {
            if (l < 0) {
                theNumber = l;
                ifFound = true;
                break;
            }
        }

        return ifFound ? theNumber : 0L;
    }

}
