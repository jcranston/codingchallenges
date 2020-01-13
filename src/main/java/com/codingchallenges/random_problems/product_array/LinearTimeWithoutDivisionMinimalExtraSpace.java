package main.java.com.codingchallenges.random_problems.product_array;

public class LinearTimeWithoutDivisionMinimalExtraSpace implements ProductArray {
    @Override
    public int[] computeProductArray(int[] arr) {
        int n = arr.length;
        int[] productArray = new int[n];

        for (int i = 0; i < n; i++) {
            productArray[i] = 1;
        }

        int temp = 1;

        // update product array to be product of all elements left of i
        for (int i = 1; i < n; i++) {
            productArray[i] = temp;
            temp *= arr[i];
        }

        temp = 1;

        // update product array to be product of all elements right of i
        for (int i = n - 1; i >= 0; i--) {
            productArray[i] *= temp;
            temp *= arr[i];
        }

        return productArray;
    }
}
