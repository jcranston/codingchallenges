package main.java.com.codingchallenges.random_problems.sorting;

import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {
    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    /**
     * MergeSort has the recurrence relation:
     * T(1) = O(1)
     * T(n) = 2T(n/2) + O(n)
     *
     * By the master theorem, this solves to O(n*log(n)) performance.
     */
    private static void mergeSort(int[] arr, int lowerIdx, int upperIdx) {
        // base case: 1 element array, no need to further break it up
        if (upperIdx - lowerIdx <= 1) {
            return;
        }

        int midIdx = lowerIdx + (upperIdx - lowerIdx) / 2;

        // recursive step: divide into two sub-problems of left and right subarrays
        mergeSort(arr, lowerIdx, midIdx);
        mergeSort(arr, midIdx, upperIdx);

        // conquer: merge the sorted left and right subarrays back together
        merge(arr, lowerIdx, midIdx, upperIdx);
    }

    /**
     * Merges left and right subarrays denoted by indices (lowerIdx, midIdx) and
     * (midIdx, upperIdx) back into the original array. midIdx is an exclusive
     * upper bound for the left subarray, and upperIdx is an exclusive upper bound
     * for the right subarray. These subarrays are temporarily stored in buffers
     * to enable writing back to the original array in place.
     */
    private static void merge(int[] arr, int lowerIdx, int midIdx, int upperIdx) {
        // temp arrays to hold left and right subarrays.
        int[] left = Arrays.copyOfRange(arr, lowerIdx, midIdx);
        int[] right = Arrays.copyOfRange(arr, midIdx, upperIdx);

        int leftIdx, rightIdx;
        leftIdx = rightIdx = 0;
        int mergedIdx = lowerIdx;

        // this code felt cleaner than first trying to copy as many as possible into one loop,
        // and then having two separate loops to copy the remaining elements back into the array.
        // even though it there are duplicate lines of code in the conditionals, this feels
        // the most compact way to represent the logic.
        while (mergedIdx < upperIdx) {
            // copy remaining elements of right array back into original array
            if (leftIdx == left.length && rightIdx < right.length) {
                arr[mergedIdx] = right[rightIdx];
                rightIdx++;
            // copy remaining elements of left array back into original array
            } else if (leftIdx < left.length && rightIdx == right.length) {
                arr[mergedIdx] = left[leftIdx];
                leftIdx++;
            // left array element is smaller than right array element
            } else if (left[leftIdx] < right[rightIdx]) {
                arr[mergedIdx] = left[leftIdx];
                leftIdx++;
            // right array element is greater than or equal to left array element
            } else {
                arr[mergedIdx] = right[rightIdx];
                rightIdx++;
            }
            mergedIdx++;
        }
    }
}
