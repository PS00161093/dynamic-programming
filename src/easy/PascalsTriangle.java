package src.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int rowIndex) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, Collections.singletonList(1));
        int counter = 0;
        while (counter < rowIndex) {
            List<Integer> from = map.get(counter);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int i = 1; i < from.size(); i++) {
                newRow.add(from.get(i - 1) + from.get(i));
            }
            newRow.add(1);
            counter++;
            map.put(counter, newRow);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            res.add(map.get(i));
        }

        return res;
    }

}
