package src.easy;

/**
 * Problem URL: https://practice.geeksforgeeks.org/problems/peak-element/1#
 */
public class PeakElement {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        System.out.println(peakElement(arr, arr.length));
    }

    public static int peakElement(int[] arr, int n) {

        int peakIndex = 0;

        for (int i = 0; i < n; i++) {
            int previousIndex = i - 1;
            int nextIndex = i + 1;

            if (previousIndex <= -1 && nextIndex < n) {
                if (arr[i] > arr[nextIndex]) {
                    peakIndex = i;
                    break;
                }
            } else if (previousIndex >= 0 && nextIndex < n) {
                if (arr[previousIndex] < arr[i] && arr[i] > arr[nextIndex]) {
                    peakIndex = i;
                    break;
                }
            } else if (previousIndex >= 0 && nextIndex >= n) {
                if (arr[i] > arr[previousIndex]) {
                    peakIndex = i;
                    break;
                }
            }
        }

        return peakIndex;
    }
}
