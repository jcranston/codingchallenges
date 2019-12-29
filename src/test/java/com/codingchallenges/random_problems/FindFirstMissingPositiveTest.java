package test.java.com.codingchallenges.random_problems;

import main.java.com.codingchallenges.random_problems.FindFirstMissingPositive;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindFirstMissingPositiveTest {
    @Test
    public void testMissingMiddlePositive() {
        // is missing a 5
        int[] arr =  { -5, -4, 0, 4, 2, -6, 7, 1, 3, 6 };
        int missing = FindFirstMissingPositive.findFirstMissingPositive(arr);

        assertEquals(missing, 5);
    }

    @Test
    public void testMissingLastPositiveValue() {
        // is missing a 3
        int[] arr =  { 2, -4, 1, -1, 0 };
        int missing = FindFirstMissingPositive.findFirstMissingPositive(arr);

        assertEquals(missing, 3);
    }

    @Test
    public void testMissingFirstPositiveValue() {
        // is missing a 1
        int[] arr =  { 0, -3, 2, -5, -5 };
        int missing = FindFirstMissingPositive.findFirstMissingPositive(arr);

        assertEquals(missing, 1);
    }

    @Test
    public void testMissingPositiveWithDuplicates() {
        // is missing a 3
        int[] arr =  { 0, -3, 0, 1, 2, -4, 1, -5, 0, 1, 2 };
        int missing = FindFirstMissingPositive.findFirstMissingPositive(arr);

        assertEquals(missing, 3);
    }

    @Test
    public void testHasNoValues() {
        // is missing a 1
        int[] arr = { };
        int missing = FindFirstMissingPositive.findFirstMissingPositive(arr);

        assertEquals(missing, 1);
    }
}
