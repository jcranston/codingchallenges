package test.java.com.codingchallenges.cci_ch1_arrays_and_strings;

import org.junit.Test;

import static main.java.com.codingchallenges.cci_ch1_arrays_and_strings.StringRotation.isSubstring;
import static main.java.com.codingchallenges.cci_ch1_arrays_and_strings.StringRotation.isStringRotation;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringRotationTest {
    @Test
    public void testIsSubstring1() {
        assertTrue(isSubstring("pl", "apple"));
    }

    @Test
    public void testIsSubstring2() {
        assertTrue(isSubstring("app", "apple"));
    }

    @Test
    public void testIsSubstring3() {
        assertTrue(isSubstring("le", "apple"));
    }

    @Test
    public void testIsSubstring4() {
        assertTrue(isSubstring("apple", "apple"));
    }

    @Test
    public void testIsSubstring5() {
        assertTrue(isSubstring("", "apple"));
    }

    @Test
    public void testIsSubstring6() {
        assertTrue(isSubstring("", ""));
    }

    @Test
    public void testIsSubstring7() {
        assertFalse(isSubstring("apple", "ple"));
    }

    @Test
    public void testIsSubstring8() {
        assertFalse(isSubstring("apple", "pear"));
    }

    @Test
    public void testStringRotation1() {
        assertTrue(isStringRotation("waterbottle", "erbottlewat"));
    }

    @Test
    public void testStringRotation2() {
        assertTrue(isStringRotation("waterbottle", "waterbottle"));
    }

    @Test
    public void testStringRotation3() {
        assertTrue(isStringRotation("waterbottle", "aterbottlew"));
    }

    @Test
    public void testStringRotation4() {
        assertFalse(isStringRotation("waterbottle", "bottlewaterb"));
    }

    @Test
    public void testStringRotation5() {
        assertFalse(isStringRotation("waterbottle", ""));
    }
}