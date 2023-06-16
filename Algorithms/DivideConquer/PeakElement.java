package Algorithms.DivideConquer;

import javax.lang.model.util.ElementScanner6;

public class PeakElement {
    public static int findPeak(int[] array){
        int len = array.length;
        if(len==0) return -1;
        if(len==1) return array[0];
        if(array[0] >= array[1]){
            return array[0];
        }

        for(int i=1; i<len - 1; i++) {
            if(array[i] >= array[i-1] && array[i] >= array[i+1]){
                return array[i];
            }
        }
        if(array[len-1] >= array[len -2]) {
            return array[len-1];
        }
        return -1;
    
    }

    public static int findPeakDC(int low, int high, int[] array, int size){
        int mid = (low) + (high - low) / 2;
        if((mid == size - 1 || array[mid + 1] <= array[mid]) &&
        (mid == 0 || array[mid - 1] <= array[mid]))
            return mid;
        
        else if(array[mid - 1] > array[mid] && mid > 0)
            return findPeakDC(low, (mid - 1), size, array);

        else
        return findPeakDC(mid + 1, high, size, array);
    }

    public static int findPeak(int arr[]) {
        int n = arr.length;
        return findPeakDC(0, n - 1, arr, n);
    }
    
}
