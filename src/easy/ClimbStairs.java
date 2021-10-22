package src.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        if (map.containsKey(n)) return map.get(n);
        else {
            int idx = 3;
            while (idx <= n) {
                map.put(idx, map.get(idx - 1) + map.get(idx - 2));
                idx++;
            }
        }

        return map.get(n);
    }
}
