import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        System.out.println(findNearestCities(numOfPoints, points, xCoordinates, yCoordinates, numOfQueriedPoints, queriedPoints));

    }

    public static List<String> findNearestCities(int numOfPoints,
                                                 String[] points,
                                                 int[] xCoordinates,
                                                 int[] yCoordinates,
                                                 int numOfQueriedPoints,
                                                 String[] queriedPoints) {

        List<String> res = new ArrayList<>();
        Map<String, Point> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.put(points[i], new Point(points[i], xCoordinates[i], yCoordinates[i]));
        }

        for (String s : queriedPoints) {

            Point q = map.get(s);
            int qx = q.x;
            int qy = q.y;

            List<Point> list = new ArrayList<>();
            for (Map.Entry<String, Point> entry : map.entrySet()) {

                String mn = entry.getKey();
                int mx = entry.getValue().x;
                int my = entry.getValue().y;

                if (!mn.equals(s)) {
                    if (qx == mx && qy == my) {
                        list.add(new Point(null, 0, 0, Integer.MAX_VALUE));
                    } else if (qx == mx) {
                        list.add(new Point(mn, mx, mx, q.getYDistance(entry.getValue())));
                    } else if (qy == my) {
                        list.add(new Point(mn, mx, my, q.getXDistance(entry.getValue())));
                    }/* else {
                        list.add(new Point(null, 0, 0, Integer.MAX_VALUE));
                    }*/
                }
            }
            Collections.sort(list);
            if (list.size() != 0) res.add(list.get(0).name);
            list.clear();
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
