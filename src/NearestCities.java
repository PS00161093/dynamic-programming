package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.abs;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.IntStream.range;

/**
 * Problem URL: https://aonecode.com/amazon-online-assessment-nearest-cities
 * <p>
 */
public class NearestCities {

    public static void main(String[] args) {
        int numOfPoints = 6;
        String[] points = {"green", "yellow", "red", "blue", "grey", "pink"};
        int[] xCoordinates = {10, 20, 15, 30, 10, 15};
        int[] yCoordinates = {30, 25, 30, 40, 25, 25};
        int numOfQueriedPoints = 4;
        String[] queriedPoints = {"grey", "blue", "red", "pink"};

        System.out.println(Arrays.toString(findNearestCities(numOfPoints, points, xCoordinates, yCoordinates,
                numOfQueriedPoints, queriedPoints)));

    }

    public static String[] findNearestCities(int numOfPoints,
                                             String[] points,
                                             int[] xCoordinates,
                                             int[] yCoordinates,
                                             int numOfQueriedPoints,
                                             String[] queriedPoints) {
        String[] res = new String[numOfQueriedPoints];
        int index = 0;
        Map<String, List<Integer>> pointsCoOrdinateMap = mapPointsToCoOrdinates(points, xCoordinates, yCoordinates);
        for (String queriedPoint : queriedPoints) {
            List<Integer> queriedPointCoOrdinates = pointsCoOrdinateMap.get(queriedPoint);
            List<String> matchingPoints = new ArrayList<>();
            findMatchingPoints(pointsCoOrdinateMap, queriedPoint, queriedPointCoOrdinates, matchingPoints);
            TreeMap<Integer, String> sortedMap = sortByNearestPoint(pointsCoOrdinateMap, queriedPointCoOrdinates, matchingPoints);
            if (sortedMap.isEmpty()) res[index] = null;
            else res[index] = sortedMap.firstEntry().getValue();
            index++;
        }

        return res;
    }

    private static TreeMap<Integer, String> sortByNearestPoint(Map<String, List<Integer>> map,
                                                               List<Integer> find,
                                                               List<String> matchingPoints) {
        return matchingPoints.stream().collect(toMap(mp ->
                        abs(map.get(mp).get(0) - find.get(0)) + abs(map.get(mp).get(1) - find.get(1)),
                mp -> mp, (a, b) -> b, TreeMap::new));
    }

    private static void findMatchingPoints(Map<String, List<Integer>> map,
                                           String queriedPoint,
                                           List<Integer> find,
                                           List<String> matchingPoints) {
        map.forEach((key, value) -> {
            if (!key.equalsIgnoreCase(queriedPoint) &&
                    (compareCoOrdinate(find, value, 0) || compareCoOrdinate(find, value, 1)))
                matchingPoints.add(key);
        });
    }

    private static boolean compareCoOrdinate(List<Integer> find, List<Integer> in, int index) {
        return in.get(index).intValue() == find.get(index).intValue();
    }

    private static Map<String, List<Integer>> mapPointsToCoOrdinates(String[] points,
                                                                     int[] xCoordinates,
                                                                     int[] yCoordinates) {
        return range(0, points.length).boxed().collect(toMap(i -> points[i], i ->
                asList(xCoordinates[i], yCoordinates[i]), (a, b) -> b));
    }

}