package src;

import static java.lang.Math.*;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
        System.out.println(maxAreaEfficient(arr));
    }

    //O(n)
    public static int maxAreaEfficient(int[] height) {
        int maxArea = 0, len = 0, bre = height.length - 1;
        while (len < bre) {
            maxArea = max(maxArea, min(height[len], height[bre]) * (bre - len));
            if (height[len] < height[bre]) len++;
            else bre--;
        }

        return maxArea;
    }

    //O(n^2)
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int len = min(height[i], height[j]);
                int bre = j - i;
                int area = len * bre;
                if (area > maxArea) maxArea = area;
            }
        }

        return maxArea;
    }

}