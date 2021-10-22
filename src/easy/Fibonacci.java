package src.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
public class Fibonacci {

    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int fib1(int n) {
        int idx = 2;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        if (map.containsKey(n)) return map.get(n);
        while (idx <= n) {
            map.put(idx, map.get(idx - 1) + map.get(idx - 2));
            idx++;
        }

        return map.get(n);
    }
}
