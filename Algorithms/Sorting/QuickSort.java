package Algorithms.Sorting;

import java.util.Random;

public class QuickSort {
    static Helper obj = new Helper();

    public static int findPivot(int left, int right) {

        Random random = new Random();
        int i1 = left + (random.nextInt(right - left) + 1);
        int i2 = left + (random.nextInt(right - left) + 1);
        int i3 = left + (random.nextInt(right - left) + 1);

        return Math.max(Math.min(i1, i2), Math.min(Math.max(i1, i2), i3));
    }

    public static int partition(int arr[], int left, int right) {
        int pivotIndex = findPivot(left, right); 
        Helper.swap(arr, right, pivotIndex);
        int pivot = arr[right]; 
        int i = left - 1;
        
        for(int j = left; j <= right - 1; j++) {
            if(arr[j] <= pivot){
                i++;
                Helper.swap(arr, i, j);
            }
        }
        Helper.swap(arr, i+1, right);
        return (i+1);
    }

    public static void QuickSort(int arr[], int left, int right){
        if(left < right){
            int pi = partition(arr, left, right);
            QuickSort(arr, left, pi - 1);
            QuickSort(arr, pi + 1, right);
        }
    }


}
