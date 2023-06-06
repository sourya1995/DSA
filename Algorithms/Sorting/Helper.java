package Algorithms.Sorting;

import java.util.*;

class Helper {
    static void printArray(int[] array, int arrSize) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
            System.out.println();
        }
    }

    static int findMin(int[] array, int start, int end) {
        if(end <= 0  || start < 0){
            return 0;
        }

        int minInd = start;
        for(int i = start + 1; i <= end; i++){
            if(array[minInd] > array[i]){
                minInd = i;
            }
            
        }
        return minInd;
    }


    static int findMax(int[] array, int start, int end){
        if(end <= 0 || start < 0){
            return 0;
        }

        int maxInd = start;
        for(int i = start + 1; i <=end; i++){
            if(array[maxInd] < array[i]){
                maxInd = i;
            }
        }
        return maxInd;
    }

}
