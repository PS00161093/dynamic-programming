package src;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.sort;

public class ThreeDigitTargetSum {

    public static void main(String[] args) {

        int[] input = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeDigitTargetSum(input));

    }

    public static List<List<Integer>> threeDigitTargetSum(int[] numbers) {

        sort(numbers);
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < numbers.length - 2; i++) {

            if (i == 0 || numbers[i] != numbers[i - 1]) {

                int low = i + 1, high = numbers.length - 1, totalSum = -numbers[i];

                while (low < high) {

                    if (numbers[low] + numbers[high] == totalSum) {
                        result.add(asList(numbers[i], numbers[low], numbers[high]));
                        while (low < high && numbers[low] == numbers[low + 1]) low++;
                        while (low < high && numbers[high] == numbers[high - 1]) high--;
                        low++;
                        high--;

                    } else if (numbers[low] + numbers[high] < totalSum) {
                        low++;

                    } else {
                        high--;
                    }
                }
            }
        }

        return result;
    }
}
