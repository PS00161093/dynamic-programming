package src;

import java.math.BigInteger;

/**
 * https://www.hackerrank.com/challenges/extra-long-factorials/
 */
public class BigFactorial {

    public static void main(String[] args) {
        extraLongFactorials(100);
    }

    public static void extraLongFactorials(int n) {
        BigInteger fact = BigInteger.valueOf(1);
        while (n > 0) {
            fact = fact.multiply(BigInteger.valueOf(n));
            n--;
        }
        System.out.println(fact);
    }

}