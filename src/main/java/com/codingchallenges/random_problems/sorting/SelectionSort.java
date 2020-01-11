package main.java.com.codingchallenges.random_problems.sorting;

import static main.java.com.codingchallenges.common.Swap.swap;

public class SelectionSort implements SortingAlgorithm {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }
}
