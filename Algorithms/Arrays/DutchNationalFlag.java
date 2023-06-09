package Algorithms;

import Algorithms.Sorting.Helper;

public class DutchNationalFlag {
    Helper helper = new Helper();
    public static int[] SelectionSort(int[] list){
        int size = list.length;
        int index = 0;
        for(int i = 0; i < size; i++){
            index = findMin(list, i, size);
            int temp = list[i];
            list[i] = list[index];
            list[index] = temp;
        }
        return list;
    }

    public static int findMin(int[] list, int start, int end) {
        int min = list[start];
        int index = start;
        for(int i = start; i < end; i++){
            if(list[i] < min){
                min = list[i];
                index = i;
            }
        }
        return index;
    }

    public static void dutchNationalFlag(int[] arr){
        int i = 0;
        int mid = 0;
        int j = arr.length - 1;
        
        while(mid <= j){
            if(arr[mid] == 0){
                helper.swap(arr, i++, mid++);
            }else if(arr[mid] == 2){
                helper.swap(arr, mid, j--);
            } else if(arr[mid] == 1){
                mid++;
            }
        }
    }
    
}
