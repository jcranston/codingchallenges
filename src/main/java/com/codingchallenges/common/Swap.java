package main.java.com.codingchallenges.common;

public abstract class Swap {
    public static void swap(int[] arr, int i, int j) {
        int n = arr.length;
        if (i >= n || j >= n || i < 0 || j < 0) {
            throw new RuntimeException("out of bounds");
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
