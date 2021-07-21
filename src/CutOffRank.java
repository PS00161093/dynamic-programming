package src;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.sort;

public class CutOffRank {

    public static int cutOffRank(int cutOffRank, int[] scores) {
        int res = 0;
        int rank = 0;
        Map<Integer, Integer> map = new HashMap<>();
        sort(scores);
        for (int i = scores.length - 1; i >= 0; i--) {
            rank = rank + 1;
            if (!map.containsKey(scores[i])) map.put(scores[i], rank);
            if (map.get(scores[i]) <= cutOffRank) res++;
        }

        return res;
    }
}
