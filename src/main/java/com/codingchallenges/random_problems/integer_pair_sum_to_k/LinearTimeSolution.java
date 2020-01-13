package main.java.com.codingchallenges.random_problems.integer_pair_sum_to_k;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LinearTimeSolution implements IntegerPairSumToK {
    @Override
    public Set<Integer> findPair(int[] arr, int k) {
        // uses O(n) space and takes O(n) time
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (visited.contains(k - arr[i])) {
                return new HashSet(Arrays.asList(k - arr[i], arr[i]));
            }
            visited.add(arr[i]);
        }
        return null;
    }
}
