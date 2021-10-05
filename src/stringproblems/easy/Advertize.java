package src.stringproblems.easy;

/**
 * https://www.hackerrank.com/challenges/strange-advertising/
 */
public class Advertize {

    public static void main(String[] args) {
        System.out.println(viralAdvertising(5));
    }

    public static int viralAdvertising(int n) {

        double liked = Math.floor(5 / 2) * 3d;
        int cumulative = 2;
        int part = n - 1;
        while (part > 0) {
            liked = Math.floor(liked / 2);
            cumulative += liked;
            liked *= 3d;
            part--;
        }

        return cumulative;
    }
}