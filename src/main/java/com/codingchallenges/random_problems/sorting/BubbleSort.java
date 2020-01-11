package main.java.com.codingchallenges.random_problems.sorting;

import static main.java.com.codingchallenges.common.Swap.swap;

public class BubbleSort implements SortingAlgorithm {
    @Override
    public void sort(int[] arr) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] < arr[i]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
