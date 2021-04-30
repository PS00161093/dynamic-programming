package src.easy;

import static java.util.Arrays.sort;
import static java.util.Arrays.stream;

/**
 * Problem URL: https://aonecode.com/amazon-online-assessment-optimizing-box-weight
 */
public class OptimizedBoxWeight {

    public static void main(String[] args) {

        int[] arr = {4, 5, 2, 3, 1, 2};

        stream(optimizingBoxWeight(arr)).forEach(System.out::println);

    }

    public static int[] optimizingBoxWeight(int[] nums) {

        sort(nums);
        int s2SetSum = 0;
        for (int n : nums) s2SetSum += n;

        int s1SetSize = 0;
        int s1SetSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int currItem = nums[i];
            s2SetSum = s2SetSum - currItem;
            s1SetSum = s1SetSum + currItem;
            s1SetSize++;
            if (s1SetSum > s2SetSum) break;
        }

        int[] s1Set = new int[s1SetSize];
        int index = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (index >= s1SetSize) break;
            else s1Set[index] = nums[i];
            index++;
        }

        return s1Set;
    }
}
