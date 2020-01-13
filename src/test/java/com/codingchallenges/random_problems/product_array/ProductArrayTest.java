package test.java.com.codingchallenges.random_problems.product_array;

import main.java.com.codingchallenges.random_problems.product_array.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class ProductArrayTest {
    private static ProductArray[] algorithms = null;

    @BeforeClass
    public static void setUp() {
        algorithms = new ProductArray[]{
            new BruteForceSolution(),
            new LinearTimeWithDivision(),
            new LinearTimeWithoutDivision(),
            new LinearTimeWithoutDivisionMinimalExtraSpace()
        };
    }

    @Test
    public void testSimpleProductArray() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] productArray = new int[]{120, 60, 40, 30, 24};
        Arrays.stream(algorithms).forEach(alg -> {
            assertArrayEquals(productArray, alg.computeProductArray(arr));
        });
    }
}