package test.java.com.codingchallenges.random_problems.cumulative_duration;

import javafx.util.Pair;
import main.java.com.codingchallenges.random_problems.cumulative_duration.CumulativeDuration;
import main.java.com.codingchallenges.random_problems.cumulative_duration.SortingAndStackSolution;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CumulativeDurationTest {
    private static CumulativeDuration[] algorithms = null;

    @BeforeClass
    public static void setUp() {
        algorithms = new CumulativeDuration[]{
            new SortingAndStackSolution()
        };
    }

    @Test
    public void testSimpleOverlap() {
        List<Pair<Integer, Integer>> intervals = Arrays.asList(
            new Pair<>(1, 3),
            new Pair<>(2, 5),
            new Pair<>(6,7)
        );
        Arrays.stream(algorithms).forEach(alg ->{
            assertEquals(5, alg.computeCumulativeDuration(intervals));
        });
    }

    @Test
    public void testNoOverlaps() {
        List<Pair<Integer, Integer>> intervals = Arrays.asList(
            new Pair<>(10, 11), // length 1
            new Pair<>(4, 8),   // length 4
            new Pair<>(1, 3)    // length 2
        );
        Arrays.stream(algorithms).forEach(alg ->{
            assertEquals(7, alg.computeCumulativeDuration(intervals));
        });
    }

    @Test
    public void testIntervalContainsAnotherInterval() {
        List<Pair<Integer, Integer>> intervals = Arrays.asList(
                new Pair<>(2, 3),  // length 4
                new Pair<>(1, 5),  // length 2
                new Pair<>(4, 10)  // length 1
        );
        Arrays.stream(algorithms).forEach(alg ->{
            assertEquals(9, alg.computeCumulativeDuration(intervals));
        });
    }
}
