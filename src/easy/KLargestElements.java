package src.easy;

import java.util.ArrayList;

import static java.util.Arrays.sort;

/**
 * Problem URL: https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1#
 */
public class KLargestElements {

    public static void main(String[] args) {

        int[] arr = {12, 5, 787, 1, 23};
        int k = 2;

        System.out.println(kLargest(arr, k));
    }

    public static ArrayList<Integer> kLargest(int[] arr, int k) {

        sort(arr);
        ArrayList<Integer> res = new ArrayList<>(k);
        int i = arr.length - 1;
        while (res.size() != k) {
            res.add(arr[i]);
            i--;
        }
        return res;
    }
}
