import java.util.Arrays;

/**
 * <a href="https://aonecode.com/interview-questions/Hackathon-Teams">...</a>*
 */
public class MaxPalette {

    public static void main(String[] args) {
        int[] arr = {6, 2, 10, 2, 11, 1, 3, 2};
        int[] arr1 = {10, 15, 9, 10, 9, 1, 3, 3};
        System.out.println(maxPalette(arr1, 5, 2));
    }

    public static int maxPalette(int[] prices, int paletteSize, int threshold) {

        int max = 0;
        int len = prices.length;
        Arrays.sort(prices);

        for (int i = 0; i < len; i++) {
            int ei = i + paletteSize - 1;
            if (ei < len) {
                int mx = prices[ei];
                int mn = prices[i];
                int diff = mx - mn;
                if (diff != 0 && diff < threshold) {
                    max++;
                }
            }
        }

        return max;
    }

}
