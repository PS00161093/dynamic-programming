package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Problem URL: https://aonecode.com/amazon-online-assessment-nearest-cities
 */
public class NearestCities {

    public static void main(String[] args) {

        int numOfPoints = 3;
        String[] points = {"green", "yellow", "red", "blue", "grey", "pink"};
        int[] xCoordinates = {10, 20, 15, 30, 10, 15};
        int[] yCoordinates = {30, 25, 30, 40, 25, 25};
        int numOfQueriedPoints = 4;
        String[] queriedPoints = {"grey", "blue", "red", "pink"};

        System.out.println(Arrays.toString(findNearestCities(numOfPoints, points, xCoordinates, yCoordinates, numOfQueriedPoints, queriedPoints)));

    }

    public static String[] findNearestCities(int numOfPoints,
                                             String[] points,
                                             int[] xCoordinates,
                                             int[] yCoordinates,
                                             int numOfQueriedPoints,
                                             String[] queriedPoints) {

        String[] res = new String[numOfQueriedPoints];
        int index = 0;

        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            String point = points[i];
            List<Integer> cor = new ArrayList<>(2);
            cor.add(xCoordinates[i]);
            cor.add(yCoordinates[i]);
            map.put(point, cor);
        }

        for (String s : queriedPoints) {

            List<Integer> find = map.get(s);
            List<String> matchingPoints = new ArrayList<>();

            for (Map.Entry<String, List<Integer>> e : map.entrySet()) {
                boolean xMatching = false;
                boolean yMatching = false;
                if (e.getValue().get(0).intValue() == find.get(0).intValue()) xMatching = true;
                if (e.getValue().get(1).intValue() == find.get(1).intValue()) yMatching = true;

                if (xMatching && yMatching) {
                } else if (xMatching || yMatching) {
                    matchingPoints.add(e.getKey());
                }
            }

            TreeMap<Integer, String> fMap = new TreeMap<>();
            for (String mp : matchingPoints) {
                List<Integer> check = map.get(mp);
                int dis = Math.abs(check.get(0) - find.get(0)) + Math.abs(check.get(1) - find.get(1));
                fMap.put(dis, mp);
            }

            if (!fMap.isEmpty()) {
                res[index] = fMap.firstEntry().getValue();
                index++;
            } else {
                res[index] = null;
                index++;
            }
        }

        return res;
    }
}

class Point implements Comparable<Point> {
    String name;
    int x;
    int y;
    int d;

    Point(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    Point(String name, int x, int y, int d) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public int compareTo(Point p) {
        return this.d - p.d;
    }

    public int getXDistance(Point p) {

        return Math.abs(this.x - p.x);
    }

    public int getYDistance(Point p) {

        return Math.abs(this.y - p.y);
    }

}
