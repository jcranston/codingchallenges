package test.java.com.codingchallenges.random_problems.integer_pair_sum_to_k;

import main.java.com.codingchallenges.random_problems.integer_pair_sum_to_k.BruteForceSolution;
import main.java.com.codingchallenges.random_problems.integer_pair_sum_to_k.IntegerPairSumToK;
import main.java.com.codingchallenges.random_problems.integer_pair_sum_to_k.LinearTimeSolution;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;

public class IntegerPairSumToKTest {
    private static IntegerPairSumToK[] algorithms = null;

    @BeforeClass
    public static void setUp() {
        algorithms = new IntegerPairSumToK[]{
            new BruteForceSolution(),
            new LinearTimeSolution()
        };
    }

    @Test
    public void testContainsValidSum() {
        int[] arr = new int[]{3, 10, -5, -1, 5};
        int k = 9;
        Arrays.stream(algorithms).forEach(alg -> {
            Set<Integer> pair = alg.findPair(arr, k);
            assertTrue(pair.contains(10));
            assertTrue(pair.contains(-1));
        });
    }

    @Test
    public void testContainsValidSumAtEndOfArray() {
        int[] arr = new int[]{3, 10, -5, -1, 5};
        int k = 4;
        Arrays.stream(algorithms).forEach(alg -> {
            Set<Integer> pair = alg.findPair(arr, k);
            assertTrue(pair.contains(-1));
            assertTrue(pair.contains(5));
        });
    }

    @Test
    public void testDoesNotContainValidSum() {
        int[] arr = new int[]{3, 10, -5, -1, 5};
        int k = 3;
        Arrays.stream(algorithms).forEach(alg -> {
            Set<Integer> pair = alg.findPair(arr, k);
            assertNull(pair);
        });
    }
}