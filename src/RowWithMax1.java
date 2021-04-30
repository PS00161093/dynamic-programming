package src;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import static java.lang.Math.max;

/**
 * Problem URL: https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1#
 */
public class RowWithMax1 {

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};

        int row = 4;
        int column = 4;

        System.out.println(rowWithMax1s(arr, row, column));
    }

    static int rowWithMax1s(int[][] arr, int n, int m) {

        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int tempCount = 0;

        for (int i = 0; i < n; i++) {
            for (int v : arr[i]) if (v == 1) tempCount++;
            map.put(i, tempCount);
            tempCount = 0;
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) maxCount = max(maxCount, e.getValue());

        TreeSet<Integer> set = new TreeSet<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (maxCount != 0 && e.getValue() == maxCount)
                set.add(e.getKey());
        }

        return set.isEmpty() ? -1 : set.first();
    }
}
