package main.java.com.codingchallenges.cci_ch8_recursion;

import java.util.ArrayList;
import java.util.List;

public abstract class PowerSet {
    public static List<List<Integer>> generatePowerSet(List<Integer> s) {
        return recGeneratePowerSet(s, 0);
    }

    private static List<List<Integer>> recGeneratePowerSet(List<Integer> s, int idx) {
        List<List<Integer>> powerSet;

        if (s.size() == idx) {
            powerSet = new ArrayList();
            powerSet.add(new ArrayList()); // base case: add empty set
        } else {
            powerSet = recGeneratePowerSet(s, idx + 1);
            int item = s.get(idx);
            List<List<Integer>> moreSubsets = new ArrayList();
            for (List<Integer> subset : powerSet) {
                List<Integer> newSubset = new ArrayList();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            powerSet.addAll(moreSubsets);
        }

        return powerSet;
    }
}
