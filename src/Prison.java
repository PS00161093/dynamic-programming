package src;

/**
 * https://www.hackerrank.com/challenges/save-the-prisoner/
 */
public class Prison {

    public static void main(String[] args) {
        System.out.println(saveThePrisoner(4, 6, 2));
    }

    public static int saveThePrisoner(int numOfPrisoners, int candies, int startPrisnor) {
        long poisoned = (startPrisnor + candies - 1) % numOfPrisoners;
        if (poisoned == 0) poisoned = numOfPrisoners;

        return (int) poisoned;
    }
}
