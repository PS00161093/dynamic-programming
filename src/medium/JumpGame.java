package src.medium;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};
        System.out.println(canJump1(arr));
    }

    public static boolean canJump1(int[] nums) {

        int len = nums.length;
        boolean[] jumpArray = new boolean[len];

        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) jumpArray[i] = true;
            else {
                int jumps = nums[i];
                for (int step = 1; step <= jumps; step++) {
                    if (i + step < len && jumpArray[i + step]) {
                        jumpArray[i] = true;
                        break;
                    }
                }
            }
        }

        return jumpArray[0];
    }

    public static boolean canJump(int[] nums) {
        int max = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
