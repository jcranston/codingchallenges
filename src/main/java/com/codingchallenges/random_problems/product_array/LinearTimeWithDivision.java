package main.java.com.codingchallenges.random_problems.product_array;

public class LinearTimeWithDivision implements ProductArray {
    @Override
    public int[] computeProductArray(int[] arr) {
        int n = arr.length;
        int[] productArray = new int[n];
        long totalProduct = 1L;
        for (int i = 0; i < n; i++) {
            totalProduct *= arr[i];
        }
        for (int i = 0; i < n; i++) {
            productArray[i] = (int) totalProduct / arr[i];
        }
        return productArray;
    }
}
