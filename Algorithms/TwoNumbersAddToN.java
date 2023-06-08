package Algorithms;
import Algorithms.Sorting.QuickSort;
import Algorithms.BruteForce.BinarySearch;

public class TwoNumbersAddToN {
    static QuickSort obj = new QuickSort();
    static BinarySearch BS = new BinarySearch();
    public static int[] findSum(int[] arr, int n){
        int[] result = new int[2];
        for(int i = 0; i < arr.length; i++){
            for (int j = i+1; j < arr.length; j++){
                if(arr[i] + arr[j] == n){
                    result[0] = arr[i];
                    result[1] = arr[j];
                    return result;
                }
            }
        }
        return arr;
    }

    public static int[] findSumQuicksort(int[] arr, int n){
        int[] result = new int[2];
        QuickSort.QuickSort(arr, 0, arr.length - 1);
        int Pointer1 = 0;
        int Pointer2 = arr.length - 1;

        int sum = 0;
        while(Pointer1 != Pointer2){
            sum = arr[Pointer1] + arr[Pointer2];
            if(sum < n){
                Pointer1++;
            } else if (sum > n){
                Pointer2--;
            }else {
                result[0] = arr[Pointer1];
                result[1] = arr[Pointer2];
                return result;
            }
        }
        return arr;
       
    }

    public static int[] findSumQuickSortBSearch(int[] arr, int n) {
        int result[] = new int[2];
        QuickSort.QuickSort(arr, 0, arr.length - 1);
        int foundIndex = 0, arrSize = arr.length;

        for(int i = 0; i < arrSize; i++){
            foundIndex = BinarySearch.binarySearch(arrSize, arr,  n -arr[i]);
            if(foundIndex != -1){
                result[0] = arr[i];
                result[1] = arr[foundIndex];
            }
        }
        return result;
    }
    
}
