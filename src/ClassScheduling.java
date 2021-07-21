package src;

import java.util.stream.IntStream;

import static java.util.Arrays.sort;

/**
 * Problem URL: https://www.geeksforgeeks.org/minimum-halls-required-for-class-scheduling/?ref=leftbar-rightbar
 */
public class ClassScheduling {

    public static void main(String[] args) {
        int[][] lectures = {{0, 5}, {1, 2}, {6, 10}, {11, 12}, {3, 4}};
        System.out.println(minHallsRequired(lectures, lectures.length));
    }

    private static int minHallsRequired(int[][] lectures, int n) {
        int hallsCount = 0;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        IntStream.range(0, lectures.length).forEach(j -> {
            startTimes[j] = lectures[j][0];
            endTimes[j] = lectures[j][1];
        });
        sort(startTimes);
        sort(endTimes);

        int i = 0;
        int j = 1;
        while (i < n && j < n) {
            if (startTimes[i] < endTimes[j]) {
                hallsCount++;
                i++;
            } else {
                hallsCount--;
                j++;
            }
        }

        return hallsCount;
    }
}
