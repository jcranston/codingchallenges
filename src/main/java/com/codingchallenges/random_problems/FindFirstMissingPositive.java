package main.java.com.codingchallenges.random_problems;

import static java.lang.Math.abs;

public abstract class FindFirstMissingPositive {
    public static int findFirstMissingPositive(int[] arr) {
        if (arr.length == 0) return 1;
        int posArraySize = seggregatePositives(arr);

        System.out.println(arr);

        for (int i = 0; i < posArraySize; i++) {
            int x = abs(arr[i]);
            if (x - 1 < posArraySize && arr[x - 1] > 0) {
                arr[x - 1] *= -1;
            }
        }

        for (int i = 0; i < posArraySize; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return posArraySize + 1;
    }

    private static int seggregatePositives(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] <= 0) {
                swap(arr, i, j);
                j--;
            } else {
                i++;
            }
        }

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
