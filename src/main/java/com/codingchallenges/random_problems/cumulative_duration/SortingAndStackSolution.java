package main.java.com.codingchallenges.random_problems.cumulative_duration;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class SortingAndStackSolution implements CumulativeDuration {
    @Override
    public int computeCumulativeDuration(List<Pair<Integer, Integer>> intervals) {
        // sort by start time ascending
        intervals.sort(Comparator.comparingInt(Pair::getKey));
        Stack<Pair<Integer, Integer>> stack = new Stack();
        Pair<Integer, Integer> firstDuration = intervals.get(0);
        stack.push(firstDuration);

        for (int i = 1; i < intervals.size(); i++) {
            Pair<Integer, Integer> interval = intervals.get(i);
            Pair<Integer, Integer> topOfStack = stack.peek();
            // no overlap, push the current interval
            if (interval.getKey() > topOfStack.getValue()) {
                stack.push(interval);
            // otherwise if the current interval extends the previous one, merge them
            } else if (interval.getValue() > topOfStack.getValue()) {
                stack.pop();
                stack.push(new Pair(topOfStack.getKey(), interval.getValue()));
            }
        }
        int cumulativeDuration = 0;
        for (Pair<Integer, Integer> interval : stack) {
            cumulativeDuration += (interval.getValue() - interval.getKey());
        }
        return cumulativeDuration;
    }
}
