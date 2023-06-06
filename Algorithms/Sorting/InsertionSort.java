package Algorithms.Sorting;

public class InsertionSort {
    public static void doinsertionSort(int[] arr, int arrSize) {
        int element, j;
        for (int i = 1; i < arrSize; i++) {
            element = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > element) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = element;   
        }

    }
}
