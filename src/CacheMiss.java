package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem URL: https://aonecode.com/amazon-online-assessment-lru
 */
public class CacheMiss {

    public static void main(String[] args) {

        int num = 6;
        Integer[] arr = {8, 3, 6, 2, 8, 8, 2, 6, 6, 7};
        int maxCacheSize = 2;

        List<Integer> pages = Arrays.asList(arr);
        System.out.println(lruCacheMisses(num, pages, maxCacheSize));

    }

    public static int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize) {

        int cacheMissCount = 0;
        List<Integer> cache = new ArrayList<>(maxCacheSize);

        for (int page : pages) {
            if (!cache.contains(page) && cache.size() == maxCacheSize) {
                cache.remove(0);
                cacheMissCount++;
            } else {
                if (cache.contains(page)) cache.remove((Integer) page);
                else cacheMissCount++;
            }

            cache.add(page);
        }

        return cacheMissCount;
    }
}
