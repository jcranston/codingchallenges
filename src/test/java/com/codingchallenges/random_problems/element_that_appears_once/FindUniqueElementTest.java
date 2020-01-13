package test.java.com.codingchallenges.random_problems.element_that_appears_once;

import main.java.com.codingchallenges.random_problems.element_that_appears_once.FindUniqueElement;
import main.java.com.codingchallenges.random_problems.element_that_appears_once.PartitionTechnique;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FindUniqueElementTest {
    private static FindUniqueElement[] algorithms = null;
    @BeforeClass
    public static void setUp() {
        algorithms = new FindUniqueElement[]{
            new PartitionTechnique()
        };
    }

    @Test
    public void testFindUniqueElementSimpleArray() {
        int[] arr = new int[]{12, 1, 12, 3, 12, 1, 1, 2, 3, 3};
        Arrays.stream(algorithms).forEach(alg -> {
            assertEquals(2, alg.findUniqueElement(arr));
        });
    }

    @Test
    public void testFindUniqueElementSmallestElement() {
        int[] arr = new int[]{12, 4, 12, 3, 12, 4, 4, 1, 3, 3};
        Arrays.stream(algorithms).forEach(alg -> {
            assertEquals(1, alg.findUniqueElement(arr));
        });
    }
}