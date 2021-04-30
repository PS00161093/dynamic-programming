package src.stringproblems.easy;

import java.util.List;

/**
 * Problem URL: https://leetcode.com/problems/count-items-matching-a-rule/
 */
public class RuleMatch {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int matchingCount = 0;

        for (List<String> l : items) {

            if ("type".equalsIgnoreCase(ruleKey) && l.get(0).equalsIgnoreCase(ruleValue)
                    || "color".equalsIgnoreCase(ruleKey) && l.get(1).equalsIgnoreCase(ruleValue)
                    || "name".equalsIgnoreCase(ruleKey) && l.get(2).equalsIgnoreCase(ruleValue))

                matchingCount++;
        }

        return matchingCount;

    }
}