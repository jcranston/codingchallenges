package main.java.com.codingchallenges.random_problems.sorting;

import static main.java.com.codingchallenges.common.Swap.swap;

public class OptimizedBubbleSort implements SortingAlgorithm {
    /**
     * Optimization comes from the fact that the nth pass finds the nth
     * largest element and puts it into the correct spot, so the subsequent
     * pass needs to only consider n - 1 elements. Therefore we know there will
     * only need to be a total of n - 1 outer passes total, and each inner
     * pass needs to consider only n - 1 - i elements.
     */
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
