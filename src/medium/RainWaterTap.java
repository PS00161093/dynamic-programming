package src.medium;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Problem URL: https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1#
 */
public class RainWaterTap {

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(trappingWater(arr, arr.length));

    }

    static int trappingWater(int[] arr, int n) {

        int res = 0;

        int[] left = new int[n];
        left[0] = arr[0];
        for (int i = 1; i < n; i++) left[i] = max(left[i - 1], arr[i]);

        int[] right = new int[n];
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) right[i] = max(arr[i], right[i + 1]);

        for (int i = 0; i < n; i++) res = res + min(left[i], right[i]) - arr[i];

        return res;
    }
}
