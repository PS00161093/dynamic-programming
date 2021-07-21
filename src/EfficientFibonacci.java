package src;

import java.util.HashMap;
import java.util.Map;

public class EfficientFibonacci {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        fib(12, map);
    }

    static int fib(int n) {
        if (n <= 3) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    static int fib(int n, Map<Integer, Integer> map) {
        if (n <= 3) return 1;
        if (map.containsKey(n)) return map.get(n);
        else {
            int num = fib(n - 1, map) + fib(n - 2, map);
            map.put(n, num);
        }

        return map.get(n);
    }
}
