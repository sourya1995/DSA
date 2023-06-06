package Algorithms.Sorting;

public class SelectionSort {
    static Helper obj = new Helper();
    public static void doSelectionSort(int[] arr, int arrSize){
        int minIndex;
        for(int i = 0; i < arrSize; i++){
            minIndex = Helper.findMin(arr, i, arrSize - 1);
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
