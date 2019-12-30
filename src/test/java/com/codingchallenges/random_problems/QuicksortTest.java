package test.java.com.codingchallenges.random_problems;

import static org.junit.Assert.*;
import org.junit.Test;

import static main.java.com.codingchallenges.random_problems.Quicksort.quicksort;

public class QuicksortTest {
    @Test
    public void testQuicksortUniqueElemsLongArray() {
        int[] arr = { 9, 2, 5, 1, 3, 10, 6, 4, 8 , 7 };
        quicksort(arr);

        assertArrayEquals(arr, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
    }

    @Test
    public void testQuicksortUniqueElemsShortArray() {
        int[] arr = { 3, 4, 5, 1, 2 };
        quicksort(arr);

        assertArrayEquals(arr, new int[] { 1, 2, 3, 4, 5 });
    }

    @Test
    public void testQuicksortWithDuplicates() {
        int[] arr = { 3, 5, 1, 4, 5, 3, 1, 4, 2 };
        quicksort(arr);

        assertArrayEquals(arr, new int[] { 1, 1, 2, 3, 3, 4, 4, 5, 5 });
    }

    @Test
    public void testQuicksortWithSingleElement() {
        int[] arr = { 3 };
        quicksort(arr);

        assertArrayEquals(arr, new int[] { 3 });
    }

    @Test
    public void testQuicksortWithNoElements() {
        int[] arr = { };
        quicksort(arr);

        assertArrayEquals(arr, new int[] { });
    }
}
