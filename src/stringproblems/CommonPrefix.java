package src.stringproblems;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class CommonPrefix {

    public static void main(String[] args) {
        String[] arr = {"cir", "car"};
        System.out.println(longestCommonPrefix1(arr));
    }

    public static String longestCommonPrefix1(String[] strs) {

        String smallest = stream(strs).collect(toMap(String::length, s -> s, (a, b) -> b, TreeMap::new)).firstEntry().getValue();

        int preFixLen = 0;
        int index = 0;
        int flag;

        while (index < smallest.length()) {
            flag = 0;
            for (String s : strs) {
                if (s.charAt(index) == smallest.charAt(index)) {
                    flag++;
                }
            }
            index++;
            if (flag == strs.length) preFixLen++;
            else break;
        }

        return smallest.substring(0, preFixLen);
    }
}
