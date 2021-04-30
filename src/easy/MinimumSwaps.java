package src.easy;

/**
 * Problem URL: https://aonecode.com/amazon-online-assessment-algorithm-swap
 */
public class MinimumSwaps {

    public static void main(String[] args) {

        int[] arr = {5, 4, 1, 2};
        System.out.println(numberOfSwap(arr));

    }

    public static int numberOfSwap(int[] num) {

        int swaps = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = i; j < num.length; j++)
                if (num[i] > num[j]) swaps++;
        }

        return swaps;
    }

}
