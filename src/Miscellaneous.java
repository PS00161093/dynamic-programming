package src;

import java.util.ArrayList;
import java.util.List;

public class Miscellaneous {

    public static void main(String[] args) {

    }

    private static String reverseS(String s) {

        if (s.length() < 2) return s;
        return reverseS(s.substring(1)) + s.charAt(0);
    }

    public static int removeDuplicates(int[] nums) {

        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (check(nums, i)) {
                res = res - 1;
                i = i + 1;
            }
        }
        return res;
    }

    public static boolean check(int[] nums, int i) {
        boolean result = false;
        if (i >= 0 && i < nums.length - 1) {
            result = nums[i] == nums[i + 1];
        }
        return result;
    }

    public static void bSearch(int[] arr, int left, int right, int num) {

        int mid = left + (right - 1) / 2;
        if (arr[mid] == num) System.out.println("Found + " + arr[mid]);
        if (num < arr[mid]) bSearch(arr, left, mid - 1, num);
        if (num > arr[mid]) bSearch(arr, mid + 1, right, num);
    }


    static String remove(String left, String right) {

        char suffix = right.charAt(right.length() - 1);
        boolean changed = false;
        for (int i = 0; i < left.length(); i++) {
            if (suffix == left.charAt(0)) {
                left = left.substring(1);
                changed = true;
            }
        }
        if (changed) {
            right = right.substring(0, right.length() - 1);
        }
        return right + "," + left;
    }


    public static int subtractProductAndSum(int n) {

        int r = n % 10;
        int q = n / 10;
        int sum = r;
        int pro = r;

        while (q != 0) {
            r = q % 10;
            sum += r;
            pro *= r;
            q /= 10;
        }

        return pro - sum;
    }

    public static int numberOfSteps(int num) {

        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
            steps = steps + 1;
        }
        return steps;
    }

    public static int[] shuffle(int[] nums, int n) {

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                index = i;
                break;
            } else {
                x.add(nums[i]);
            }
        }
        x.add(nums[index]);
        index = index + 1;
        for (int j = index; j < nums.length; j++) {
            y.add(nums[j]);
        }

        index = 0;
        for (Integer integer : x) {
            if (index >= 0 && index < nums.length) {
                nums[index] = integer;
            }
            index = index + 2;
        }

        index = 1;
        for (Integer integer : y) {
            if (index > 0 && index < nums.length) {
                nums[index] = integer;
            }
            index = index + 2;
        }

        return nums;
    }
}
