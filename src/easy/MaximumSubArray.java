package src.easy;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int max, curr;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        else {
            max = nums[0];
            curr = max;
            for (int i = 1; i < nums.length; i++) {
                curr = Math.max(nums[i] + curr, nums[i]);
                max = Math.max(curr, max);
            }

            return max;
        }
    }

}