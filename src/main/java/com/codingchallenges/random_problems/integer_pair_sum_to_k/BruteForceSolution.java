package main.java.com.codingchallenges.random_problems.integer_pair_sum_to_k;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BruteForceSolution implements IntegerPairSumToK {
    @Override
    public Set<Integer> findPair(int[] arr, int k) {
        // try all (n choose 2) = O(n^2) pairs of the array
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    return new HashSet(Arrays.asList(arr[i], arr[j]));
                }
            }
        }
        return null;
    }
}
