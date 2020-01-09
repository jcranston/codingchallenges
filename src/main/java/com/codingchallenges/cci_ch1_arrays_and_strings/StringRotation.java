package main.java.com.codingchallenges.cci_ch1_arrays_and_strings;

public abstract class StringRotation {
    /**
     * Returns if `s1` is a substring of `s2`.
     */
    public static boolean isSubstring(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        for (int i = 0; i <= n2 - n1; i++) {
            int j;
            for (j = 0; j < n1; j++) {
                if (s1.charAt(j) != s2.charAt(i + j)) {
                    break;
                }
            }
            if (j == n1) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns if `s2` is a rotation of `s1`, with the constraint
     * of only having one call to `isSubstring`
     *
     * s1 = "erbottlewat"
     * s2 = "watterbottle"
     *
     * Here, s2 is a rotation of s1.
     *
     * Solution: check if s2 is a substring of s1 concatenated with itself.
     */
    public static boolean isStringRotation(String s1, String s2) {
        return isSubstring(s1, s2 + s2);
    }
}
