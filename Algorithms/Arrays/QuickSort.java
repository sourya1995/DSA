package Algorithms.Arrays;

public class QuickSort {
    static int partition(int[] arr, int low, int high){
        int pivotValue = arr[low];
        int i = low;
        int j = high;

        while(i < j){
            while(i <= high && arr[i] <= pivotValue) i++;
            while(arr[j] > pivotValue) j--;
            if(i < j){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[j] = temp;
            }
        }

        arr[low] = arr[j];
        arr[j] = pivotValue;

        return j;
    }

    static void quickSortRecursive(int[] arr, int low, int high){
        if(high > low){
            int pivotValue = partition(arr, low, high);
            quickSortRecursive(arr, low, pivotValue - 1);
            quickSortRecursive(arr, pivotValue + 1, high);
        }
    }

    static void quickSort(int[] arr){
        quickSortRecursive(arr, 0, arr.length - 1);
    }
}
