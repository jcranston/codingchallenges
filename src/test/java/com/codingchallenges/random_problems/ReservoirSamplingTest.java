package test.java.com.codingchallenges.random_problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static main.java.com.codingchallenges.random_problems.ReservoirSampling.sampleReservoir;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ReservoirSamplingTest {
    @Test
    public void sampleSmallResevoirSmallStream() {
        Stream<Integer> s = (Arrays.asList(4, 6, 1, 3, 7, 2, 9)).stream();
        int k = 3;
        int[] reservoir = sampleReservoir(s, k);
        assertEquals(reservoir.length, k);
    }

    @Test
    public void sampleOneElementSmallStream() {
        Stream<Integer> s = (Arrays.asList(4, 6, 1, 3, 7, 2, 9)).stream();
        int k = 1;
        int[] reservoir = sampleReservoir(s, k);
        assertEquals(reservoir.length, k);
    }

    @Test
    public void sampleReservoirEqualToStream() {
        Stream<Integer> s = (Arrays.asList(4, 6, 1)).stream();
        int k = 3;
        int[] reservoir = sampleReservoir(s, k);
        assertArrayEquals(reservoir, new int[] {4, 6, 1});
        assertEquals(reservoir.length, 3);
    }
}
