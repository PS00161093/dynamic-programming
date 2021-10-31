package src.stringproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("FXSHRXW"));
    }

    public static int titleToNumber(String columnTitle) {

        int excelNumber = 1;
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Map<String, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(String.valueOf(c), excelNumber++);

        if (map.containsKey(columnTitle)) return map.get(columnTitle);

        excelNumber = 0;
        int columnTitleLength = columnTitle.length();
        for (int i = columnTitleLength - 1; i >= 0; i--) {
            excelNumber = excelNumber + (int) (Math.pow(26, (columnTitleLength - i - 1)) * map.get(String.valueOf(columnTitle.charAt(i))));
        }

        return excelNumber;
    }
}
