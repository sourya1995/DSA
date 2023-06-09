package Algorithms;

import Algorithms.Sorting.Helper;

public class CountElementOccurrence {
    public static int calcFreq(int[] arr, int key){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == key) count++;
        }
        return count;
    }

    public static int calcFreqBinarySearch(int[] arr, int key){
        int arrSize = arr.length;
        Helper obj = new Helper();
        int index = obj.binarySearch(key, arr, arrSize);

        if(index == -1) return 0;

        int count = 1;

        int start = index - 1;
        while(start >= 0 && arr[start] == key){
            count++;
            start--;
        }

        int end = index + 1;
        while(end < arrSize && arr[end] == key){
            count++;
            end++;
        }

        return count;
    }
}
