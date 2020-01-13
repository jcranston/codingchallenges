package main.java.com.codingchallenges.random_problems.product_array;

public class BruteForceSolution implements ProductArray {
    /**
     * Time complexity: O(n^2), space complexity: O(n)
     * We can do better!
     */
    @Override
    public int[] computeProductArray(int[] arr) {
        int n = arr.length;
        int[] productArray = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    temp *= arr[j];
                }
            }
            productArray[i] = temp;
        }
        return productArray;
    }
}
