package main.java.com.codingchallenges.cci_ch8_recursion.magic_index;

public class BinarySearchSolution implements MagicIndex {
    @Override
    public int findMagicIndex(int[] arr) {
        return recGetMagicIdxDistinctIntegers(arr, 0, arr.length);
    }

    private static int recGetMagicIdxDistinctIntegers(int[] arr, int lowerIdx, int upperIdx) {
        int midIdx = lowerIdx + (upperIdx - lowerIdx) / 2; // prevent integer overflow

        // base case 1: found a magic index
        if (midIdx == arr[midIdx]) {
            return midIdx;
        }

        // base case 2: array length is one and have not found a magic index
        if (upperIdx - lowerIdx == 1) {
            return -1;
        }

        // recursive step: if midIdx < arr[midIdx], there cannot be a
        // magic index i that is greater than midIdx, so search lower array.
        // if midIdx > arr[midIdx], there cannot be a magic index i that is
        // less than midIdx, so search upper array
        if (midIdx < arr[midIdx]) {
            return recGetMagicIdxDistinctIntegers(arr, lowerIdx, midIdx);
        } else {
            return recGetMagicIdxDistinctIntegers(arr, midIdx, upperIdx);
        }
    }
}
