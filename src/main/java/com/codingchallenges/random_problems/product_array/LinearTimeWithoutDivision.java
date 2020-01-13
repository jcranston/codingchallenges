package main.java.com.codingchallenges.random_problems.product_array;

public class LinearTimeWithoutDivision implements ProductArray {
    @Override
    public int[] computeProductArray(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] productArray = new int[n];

        // initialize zero values on left side of left array and right side of right array
        left[0] = 1;
        right[n - 1] = 1;

        // compute cumulative product of arr before index i, for each i
        for (int i = 1; i < n; i++) {
            left[i] = arr[i - 1] * left[i - 1];
        }

        // compute cumulative product of arr after index i, for each i
        for (int i = n - 2; i >= 0; i--) {
            right[i] = arr[i + 1] * right[i + 1];
        }

        // product of entire arr excluding element i is the product of left[i] and right[i]
        for (int i = 0; i < n; i++) {
            productArray[i] = left[i] * right[i];
        }

        return productArray;
    }
}
