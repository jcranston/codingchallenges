package test.java.com.codingchallenges.cci_ch1_arrays_and_strings;

import org.junit.Test;

import static main.java.com.codingchallenges.cci_ch1_arrays_and_strings.PalindromePermutation.*;
import static org.junit.Assert.*;

public class PalindromePermutationTest {
    @Test
    public void testPermutationOfPalindrome1() {
        // permutations are "taco cat" and "atco cta", etc.
        testIsPermutationOfPalindrome("Tact Coa");
    }

    @Test
    public void testPermutationOfPalindrome2() {
        testIsPermutationOfPalindrome("A Man A Plan A Canal Panama");
    }

    @Test
    public void testPermutationOfPalindrome3() {
        testIsNotPermutationOfPalindrome("apple");
    }

    @Test
    public void testPermutationOfPalindrome4() {
        testIsPermutationOfPalindrome("appllee");
    }

    @Test
    public void testPermutationOfPalindrome5() {
        testIsPermutationOfPalindrome("ppllee");
    }

    private void testIsPermutationOfPalindrome(String s) {
        assertTrue(isPermutationOfPalindromeInitialSolution(s));
        assertTrue(isPermutationOfPalindromeCountsArray(s));
        assertTrue(isPermutationOfPalindromeOddCounter(s));
        assertTrue(isPermutationOfPalindromeBitVector(s));
    }

    private void testIsNotPermutationOfPalindrome(String s) {
        assertFalse(isPermutationOfPalindromeInitialSolution(s));
        assertFalse(isPermutationOfPalindromeCountsArray(s));
        assertFalse(isPermutationOfPalindromeOddCounter(s));
        assertFalse(isPermutationOfPalindromeBitVector(s));
    }
}