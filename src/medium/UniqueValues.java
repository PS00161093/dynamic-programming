package src.medium;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.stream;

/**
 * Problem URL: https://www.geeksforgeeks.org/maximum-number-of-unique-values-in-the-array-after-performing-given-operations
 */
public class UniqueValues {

    public static void main(String[] args) {

        int[] arr = {5, 6, 7, 8, 8};

        maxUniqueValues(arr, arr.length);
    }

    private static void maxUniqueValues(int[] arr, int length) {

        Set<Integer> set = new HashSet<>();

        stream(arr).forEach(set::add);
        for (int n : arr) {
            int inc = n + 1;
            int dec = n - 1;
            if (!set.contains(inc) && set.size() < length) {
                set.add(inc);
            } else if (!set.contains(dec) && set.size() < length) {
                set.add(dec);
            }
        }

        System.out.println(set.size());
    }


}
