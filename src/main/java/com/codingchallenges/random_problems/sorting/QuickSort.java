package main.java.com.codingchallenges.random_problems.sorting;

import static main.java.com.codingchallenges.common.Swap.swap;

public class QuickSort implements SortingAlgorithm {
    @Override
    public void sort(int[] arr) {
        if (arr.length > 0 && arr != null) {
            quicksortImpl(arr, 0, arr.length - 1);
        }
    }

    private static void quicksortImpl(int[] arr, int idxLower, int idxUpper) {
        int idxPivot = partition(arr, idxLower, idxUpper);
        if (idxLower < idxPivot - 1) {
            quicksortImpl(arr, idxLower, idxPivot - 1);
        }
        if (idxPivot < idxUpper) {
            quicksortImpl(arr, idxPivot, idxUpper);
        }
    }

    private static int partition(int[] arr, int idxLower, int idxUpper) {
        int pivot = arr[(idxLower + idxUpper) / 2];
        while (idxLower <= idxUpper) {
            while (arr[idxLower] < pivot) {
                idxLower++;
            }
            while (arr[idxUpper] > pivot) {
                idxUpper--;
            }
            if (idxLower <= idxUpper) {
                swap(arr, idxLower, idxUpper);
                idxLower++;
                idxUpper--;
            }
        }
        return idxLower;
    }
}
