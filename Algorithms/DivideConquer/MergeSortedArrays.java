package Algorithms.DivideConquer;

import java.util.ArrayList;

public class MergeSortedArrays {
    public static int n = 4;
    public static ArrayList<Integer> mergeSortedArrays(int[][] array, ArrayList<Integer> Output){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                Output.add(array[i][j]);
            }
        }
        Collections.sort(Output);
        return Output;
    }

    public static void sortAndMerge(int left, int right, int[] result){
        int leftIndex = left * n;
        int rightIndex = ((left + right) / 2 + 1) * n;

        int leftSize = ((left + right) / 2 - left + 1) * n;
        int rightSize = (right -  (left + right) / 2 ) * n;

        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for(int i=0; i < leftSize; i++)
            leftArr[i] = result[leftIndex + i];

        for(int i=0; i < rightSize; i++)
            rightArr[i] = result[rightIndex + i];

        int leftCurr = 0;
        int rightCurr = 0;
        int currIndex = leftIndex;
        while(leftCurr + rightCurr < leftSize + rightSize){
            if(rightCurr == rightSize || (leftCurr != leftSize && leftArr[leftCurr] < rightArr[rightCurr])) {
                result[currIndex] = leftArr[leftCurr];
                leftCurr++;
                currIndex++;
            } else {
                result[currIndex] = rightArr[rightCurr];
                rightCurr++;
                currIndex++;
            }
        }

    }

    public static void mergeSortedRecursive(int[][] arr, int left, int right, int[] result){
        if(left == right) {
            for(int i =0; i < n; i++){
                result[left * n + i] = arr[left][i];
            } 
        } else {
            mergeSortedRecursive(arr, left, (left+ right) / 2, result);
            mergeSortedRecursive(arr, (left+right)/2 + 1, right, result);
            sortAndMerge(left, right, result);
        }
    }

    public static void mergeSortedArrays(int[][] arr, int k, int[] result){
        mergeSortedRecursive(arr, 0, k-1, result);
    }
}
