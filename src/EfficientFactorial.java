package src;

import java.util.HashMap;
import java.util.Map;

public class EfficientFactorial {

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        fact(12, map);
    }

    private static int fact(int n, Map<Integer, Integer> map) {

        if (n <= 1) return 1;
        if (map.containsKey(n)) return map.get(n);
        else map.put(n, n * fact(n - 1, map));
        return map.get(n);
    }
}
