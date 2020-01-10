package main.java.com.codingchallenges.cci_ch1_arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

public abstract class PalindromePermutation {
    /**
     * First attempt before looking at the solution in the book. Tests pass!
     * Subsequent implementations are from studying the solution.
     */
    public static boolean isPermutationOfPalindromeInitialSolution(String s) {
        String inputChars = s.toLowerCase().replaceAll("\\s+", "");
        Map<Character, Integer> charsToCounts = new HashMap<>();

        for (int i = 0; i < inputChars.length(); i++) {
            char c = inputChars.charAt(i);
            Integer curCount = charsToCounts.get(c);
            if (curCount == null) {
                charsToCounts.put(c, 1);
            } else {
                charsToCounts.put(c, curCount + 1);
            }
        }
        int numCharactersWithOddCounts = 0;
        for (Map.Entry entry : charsToCounts.entrySet()) {
            if ((int) entry.getValue() % 2 == 1) {
                numCharactersWithOddCounts++;
            }
            if (numCharactersWithOddCounts > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Implementation uses a counts array instead of a HashMap.
     */
    public static boolean isPermutationOfPalindromeCountsArray(String s) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int[] charCounts = new int[z - a + 1];
        for (char c : s.toCharArray()) {
            int x = getCharNumber(c);
            if (x > 0) {
                charCounts[x]++;
            }
        }
        boolean foundOddCount = false;
        for (int count : charCounts) {
            if (count % 2 == 1) {
                if (foundOddCount) {
                    return false;
                }
                foundOddCount = true;
            }
        }
        return true;
    }

    /**
     * Continuously keeps track of counter of # of odd elements in the
     * counts array and then returns if that counter is no greater than 1.
     * Slight optimization from previous algorithm.
     */
    public static boolean isPermutationOfPalindromeOddCounter(String s) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int[] charCounts = new int[z - a + 1];
        int oddCounter = 0;
        for (char c : s.toCharArray()) {
            int x = getCharNumber(c);
            if (x > 0) {
                if (++charCounts[x] % 2 == 1) {
                    oddCounter++;
                } else {
                    oddCounter--;
                }
            }
        }
        return oddCounter <= 1;
    }

    /**
     * Uses nifty bit vector representation. Bit toggled to off indicates
     * an even number count for that character represented by idx. Bit
     * toggle to on indicates an odd number count for that character.
     * (bitVector & (bitVector - 1)) == 0 indicates only 1 bit is on.
     */
    public static boolean isPermutationOfPalindromeBitVector(String s) {
        int bitVector = 0x0;
        for (char c : s.toCharArray()) {
            int idx = getCharNumber(c);
            if (idx < 0) continue;
            int mask = 1 << idx;
            if ((bitVector & mask) == 0) { // bit off
                bitVector |= mask; // toggle bit on
            } else {
                bitVector &= ~mask; // toggle bit off
            }
        }
        // if 1 bit is present only, and'ing with value - 1 should be 0
        return bitVector == 0 || (bitVector & (bitVector - 1)) == 0;
    }

    private static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }
}
