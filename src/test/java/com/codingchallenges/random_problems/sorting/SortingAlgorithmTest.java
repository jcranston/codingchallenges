package test.java.com.codingchallenges.random_problems.sorting;

import main.java.com.codingchallenges.random_problems.sorting.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class SortingAlgorithmTest {
    private static SortingAlgorithm[] algorithms = null;
    @BeforeClass
    public static void setUp() {
        algorithms = new SortingAlgorithm[]{
            new BubbleSort(),
            new OptimizedBubbleSort(),
            new InsertionSort(),
            new SelectionSort(),
            new MergeSort(),
            new QuickSort(),
        };
    }

    @Test
    public void testQuicksortUniqueElemsLongArray() {
        Arrays.stream(algorithms).forEach(alg -> {
            int[] arr = { 9, 2, 5, 1, 3, 10, 6, 4, 8 , 7 };
            alg.sort(arr);
            assertArrayEquals(arr, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        });
    }

    @Test
    public void testQuicksortUniqueElemsShortArray() {
        Arrays.stream(algorithms).forEach(alg -> {
            int[] arr = { 4, 3, 5, 2, 1 };
            alg.sort(arr);
            assertArrayEquals(arr, new int[] { 1, 2, 3, 4, 5 });
        });
    }

    @Test
    public void testQuicksortWithDuplicates() {
        Arrays.stream(algorithms).forEach(alg -> {
            int[] arr = { 3, 5, 1, 4, 5, 3, 1, 4, 2 };
            alg.sort(arr);
            assertArrayEquals(arr, new int[] { 1, 1, 2, 3, 3, 4, 4, 5, 5 });
        });
    }

    @Test
    public void testQuicksortWithSingleElement() {
        Arrays.stream(algorithms).forEach(alg -> {
            int[] arr = { 3 };
            alg.sort(arr);
            assertArrayEquals(arr, new int[] { 3 });
        });
    }

    @Test
    public void testQuicksortWithNoElements() {
        Arrays.stream(algorithms).forEach(alg -> {
            int[] arr = { };
            alg.sort(arr);
            assertArrayEquals(arr, new int[] { });
        });
    }

    @Test
    public void testQuicksortAlreadySorted() {
        Arrays.stream(algorithms).forEach(alg -> {
            int[] arr = { 1, 2, 3, 4, 5 };
            alg.sort(arr);
            assertArrayEquals(arr, new int[] { 1, 2, 3, 4, 5 });
        });
    }

    @Test
    public void testAlmostSortedExceptLastTwo() {
        Arrays.stream(algorithms).forEach(alg -> {
            int[] arr = { 1, 2, 3, 4, 5, 6, 7, 9, 8 };
            alg.sort(arr);
            assertArrayEquals(arr, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        });
    }

    @Test
    public void testAlmostSortedExceptFirstTwo() {
        Arrays.stream(algorithms).forEach(alg -> {
            int[] arr = { 2, 1, 3, 4, 5, 6, 7, 8, 9 };
            alg.sort(arr);
            assertArrayEquals(arr, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        });
    }

    @Test
    public void testSortingVeryLargeArray() {
        int n = 1000;
        int[] arr = new int[n]; // very large array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(n);
        }
        Arrays.stream(algorithms).forEach(alg -> {
            alg.sort(arr);
            for (int i = 0; i < n - 1; i++) {
                assertTrue(arr[i] <= arr[i + 1]);
            }
        });
    }
}
