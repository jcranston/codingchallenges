package main.java.com.codingchallenges.cci_ch8_recursion.magic_index;

public class BruteForceSolution implements MagicIndex {
    @Override
    public int findMagicIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
