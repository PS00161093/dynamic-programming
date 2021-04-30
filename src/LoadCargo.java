package src;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

/**
 * Problem URL: https://aonecode.com/interview-question/load_cargo
 */
public class LoadCargo {

    public static void main(String[] args) {

        int num = 5;
        int[] containers = {2, 2, 3, 1, 1};
        int itemSize = 5;
        int[] itemsPerContainer = {2, 3, 5, 1, 5};
        int cargoSize = 20;

        System.out.println(loadTheCargo(num, containers, itemSize, itemsPerContainer, cargoSize));
    }

    public static int loadTheCargo(int num, int[] containers, int itemSize, int[] itemsPerContainer, long cargoSize) {

        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < num; i++) for (int j = 0; j < containers[i]; j++) set.add(itemsPerContainer[i]);
        sort(set);

        int index = set.size() - 1;
        int totalSum = 0, counter = 0;

        while (cargoSize > counter && index >= 0) {
            totalSum += set.get(index);
            counter++;
            index--;
        }

        return totalSum;
    }
}
