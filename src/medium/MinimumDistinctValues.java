package src.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistinctValues {

    public static void main(String[] args) throws java.text.ParseException {

        int[] arr = {1, 1, 2, 4, 4, 3, 3, 3, 5};
        System.out.println(minDistinctValues(arr, 4));
    }

    public static int minDistinctValues(int[] array, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : array) {
            if (map.containsKey(n)) map.put(n, map.get(n) + 1);
            else map.put(n, 1);
        }

        List<Helper> list = new ArrayList<>();
        map.forEach((key, value) -> list.add(new Helper(key, value)));
        Collections.sort(list);

        while (k > 0) {
            k = k - list.get(0).occurrence;
            if (k < 0) break;
            else list.remove(list.get(0));
        }

        return list.size();
    }
}

class Helper implements Comparable<Helper> {

    public int value;
    public int occurrence;

    public Helper(int value, int occurrence) {
        this.value = value;
        this.occurrence = occurrence;
    }

    public int compareTo(Helper helper) {

        return this.occurrence - helper.occurrence;
    }
}
