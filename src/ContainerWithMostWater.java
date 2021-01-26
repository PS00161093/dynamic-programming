package src;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));

    }

    public static int maxArea(int[] height) {

        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int len = Math.min(height[i], height[j]);
                int bre = j - i;
                int area = len * bre;
                if (area > maxArea) maxArea = area;
            }
        }

        return maxArea;
    }
}
