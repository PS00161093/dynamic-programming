package src.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.sort;
import static java.util.stream.Collectors.toCollection;

/**
 * Sort on the frequency of number in descending order.
 * If frequency is same, sort on value in ascending order.
 */
public class SortByFrequencyAndValue {

    public static void main(String[] args) {

        int[] arr = {5, 2, 1, 3, 2};

        System.out.println(kTop(arr));

    }

    static ArrayList<Integer> kTop(int[] a) {

        ArrayList<Item> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a) {
            if (map.containsKey(num)) {
                int fre = map.get(num);
                map.put(num, fre + 1);
                list.removeIf(i -> i.value == num);
                list.add(new Item(num, fre + 1));
            } else {
                map.put(num, 1);
                list.add(new Item(num, 1));
            }
        }
        sort(list);

        return list.stream().map(l -> l.value).collect(toCollection(ArrayList::new));
    }

}

class Item implements Comparable<Item> {

    int value;
    int frequency;

    Item(int val, int fre) {
        this.value = val;
        this.frequency = fre;
    }

    public int compareTo(Item i) {

        return i.frequency == this.frequency ? this.value - i.value : i.frequency - this.frequency;
    }

}