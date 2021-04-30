package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.sort;

/**
 * Problem URL: https://aonecode.com/amazon-online-assessment-transaction-logs
 */
public class TransactionLogs {

    public static void main(String[] args) {

        String[] logs = {
                "345366 899212 45",
                "029323 382391 23",
                "382391 345366 15",
                "029323 382391 77",
                "345366 382391 23",
                "029323 345366 13",
                "382391 382391 23"
        };

        int threshold = 3;

        System.out.println(Arrays.toString(processLogFile(logs, threshold)));
    }

    public static String[] processLogFile(String[] logs, int threshold) {

        Map<String, Integer> usersCountMap = new HashMap<>();

        for (String log : logs) {
            String sender = log.split(" ")[0];
            String receiver = log.split(" ")[1];

            addCount(usersCountMap, sender);
            if (!sender.equals(receiver)) addCount(usersCountMap, receiver);
        }

        return usersOverThreshold(threshold, usersCountMap);
    }

    private static String[] usersOverThreshold(int threshold, Map<String, Integer> map) {

        List<String> list = new ArrayList<>();
        map.forEach((key, value) -> {
            if (value >= threshold) list.add(key);
        });
        sort(list);

        return list.toArray(new String[0]);
    }

    private static void addCount(Map<String, Integer> map, String user) {

        if (map.containsKey(user)) map.put(user, map.get(user) + 1);
        else map.put(user, 1);
    }
}
