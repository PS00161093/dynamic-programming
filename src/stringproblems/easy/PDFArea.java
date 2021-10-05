package src.stringproblems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/designer-pdf-viewer/
 */
public class PDFArea {

    public static void main(String[] args) {
        System.out.println(designerPdfViewer(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8),
                "torn"));
    }

    public static int designerPdfViewer(List<Integer> h, String word) {

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) map.put(alphabet[i], h.get(i));
        int max = 0;
        for (char c : word.toCharArray()) max = Math.max(max, map.get(c));

        return max * word.length();
    }
}
