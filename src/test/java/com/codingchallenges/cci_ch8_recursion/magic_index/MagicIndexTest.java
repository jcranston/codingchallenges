package test.java.com.codingchallenges.cci_ch8_recursion.magic_index;

import main.java.com.codingchallenges.cci_ch8_recursion.magic_index.BinarySearchSolution;
import main.java.com.codingchallenges.cci_ch8_recursion.magic_index.MagicIndex;
import main.java.com.codingchallenges.cci_ch8_recursion.magic_index.BruteForceSolution;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MagicIndexTest {
    private static MagicIndex[] algorithms = null;

    @BeforeClass
    public static void setUp() {
        algorithms = new MagicIndex[]{
            new BruteForceSolution(),
            new BinarySearchSolution()
        };
    }

    @Test
    public void testDistinctIntegers1() {
        //               idx:  0,  1, 2, 3, 4, 5, 6
        int[] arr = new int[]{-5, 0, 2, 5, 7, 9, 11};
        Arrays.stream(algorithms).forEach(alg ->
            assertEquals(2, alg.findMagicIndex(arr)) // lower half of array
        );
    }

    @Test
    public void testDistinctIntegers2() {
        //               idx:  0, 1, 2, 3, 4, 5, 6
        int[] arr = new int[]{-5, 0, 3, 5, 7, 9, 11};
        Arrays.stream(algorithms).forEach(alg ->
            assertEquals(-1, alg.findMagicIndex(arr)) // not in array
        );
    }

    @Test
    public void testDistinctIntegers3() {
        //               idx:  0, 1, 2, 3, 4, 5, 6
        int[] arr = new int[]{-1, 0, 1, 2, 3, 5, 7};
        Arrays.stream(algorithms).forEach(alg ->
            assertEquals(5, alg.findMagicIndex(arr)) // upper half of array
        );
    }

    @Test
    public void testDistinctIntegers4() {
        //               idx: 0, 1, 2, 3, 4, 5, 6
        int[] arr = new int[]{0, 2, 3, 4, 5, 6, 7};
        Arrays.stream(algorithms).forEach(alg ->
            assertEquals(0, alg.findMagicIndex(arr)) // smallest idx in array
        );
    }

    @Test
    public void testDistinctIntegers5() {
        //               idx:  0, 1, 2, 3, 4, 5, 6
        int[] arr = new int[]{-1, 0, 1, 2, 3, 4, 6};
        Arrays.stream(algorithms).forEach(alg ->
            assertEquals(6, alg.findMagicIndex(arr)) // largest idx in array
        );
    }

    @Test
    public void testDistinctIntegers6() {
        //               idx:  0, 1, 2, 3, 4, 5, 6
        int[] arr = new int[]{-1, 0, 1, 3, 5, 6, 7};
        Arrays.stream(algorithms).forEach(alg ->
            assertEquals(3, alg.findMagicIndex(arr)) // middle elem in array
        );
    }

    @Test
    public void testDistinctIntegers7() {
        //               idx:  0, 1, 2, 3, 4, 5, 6, 7
        int[] arr = new int[]{-1, 0, 1, 2, 4, 6, 7, 8};
        Arrays.stream(algorithms).forEach(alg ->
            assertEquals(4, alg.findMagicIndex(arr)) // even size array
        );
    }

    @Test
    public void testDistinctIntegers8() {
        //               idx:  0, 1
        int[] arr = new int[]{-1, 1};
        Arrays.stream(algorithms).forEach(alg ->
            assertEquals(1, alg.findMagicIndex(arr)) // small array
        );
    }

    @Test
    public void testDistinctIntegers9() {
        //               idx: 0, 1, 2
        int[] arr = new int[]{0, 1, 2};
        Arrays.stream(algorithms).forEach(alg ->
            assertNotEquals(-1, alg.findMagicIndex(arr)) // multiple solutions
        );
    }
}