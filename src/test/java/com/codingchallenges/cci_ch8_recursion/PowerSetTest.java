package test.java.com.codingchallenges.cci_ch8_recursion;

import main.java.com.codingchallenges.cci_ch8_recursion.PowerSet;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class PowerSetTest {
    @Test
    public void testSimplePowerSet() {
        List<List<Integer>> powerSet = PowerSet.generatePowerSet(Arrays.asList(1, 2, 3));

        Set<Set<Integer>> asSets = new HashSet<>();
        for (List<Integer> setAsList : powerSet) {
             Set<Integer> set = new HashSet();
             set.addAll(setAsList);
             asSets.add(set);
        }

        assertEquals(asSets.size(), 8);
        assertTrue(asSets.contains(new HashSet<Integer>())); // empty set
        assertTrue(asSets.contains(new HashSet(Arrays.asList(1))));
        assertTrue(asSets.contains(new HashSet(Arrays.asList(2))));
        assertTrue(asSets.contains(new HashSet(Arrays.asList(3))));
        assertTrue(asSets.contains(new HashSet(Arrays.asList(1, 2))));
        assertTrue(asSets.contains(new HashSet(Arrays.asList(1, 3))));
        assertTrue(asSets.contains(new HashSet(Arrays.asList(2, 3))));
        assertTrue(asSets.contains(new HashSet(Arrays.asList(1, 2, 3))));
    }
}