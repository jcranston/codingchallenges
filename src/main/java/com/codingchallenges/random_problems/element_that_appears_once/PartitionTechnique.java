package main.java.com.codingchallenges.random_problems.element_that_appears_once;

import static main.java.com.codingchallenges.common.Swap.swap;

public class PartitionTechnique implements FindUniqueElement {
    @Override
    public int findUniqueElement(int[] arr) {
        return recFindUniqueElement(arr, 0, arr.length - 1);
    }

    /*
              l             p
        idx:  0, 1,  2, 3,  4, 5, 6, 7, 8, 9
        arr: 12, 1, 12, 3, 12, 1, 1, 2, 3, 3

              l             p         u
        idx:  0, 1,  2, 3,  4, 5, 6,  7,  8,  9
        arr:  1  1   1  2   3  3  3  12  12  12
     */
    private static int recFindUniqueElement(int[] arr, int idxLower, int idxUpper) {
        if (idxLower == idxUpper) {
            return arr[idxLower];
        }

        // partitions the array such that all elements >= the pivot are to the right
        int idxPivot = partition(arr, idxLower, idxUpper);

        // if there is not a multiple of 3 elements above (and including) the pivot
        if (idxPivot < idxUpper && (idxUpper - (idxPivot - 1)) % 3 != 0) {
            return recFindUniqueElement(arr, idxPivot + 1, idxUpper);

        // otherwise if there is not a multiple of 3 elements less than the pivot
        } else if (idxLower < idxPivot && (idxPivot - idxLower) % 3 != 0) {
            return recFindUniqueElement(arr, idxLower, idxPivot - 1);
        }

        return -1; // fix later
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
