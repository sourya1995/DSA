package Algorithms.DivideConquer;

import java.util.Arrays;

public class ShuffleIntegers {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void shuffleArray(int[] array, int size) {
        for (int i = 0, q = 1, k = size; i < size; i++, k++, q++) {
            for (int j = k; j > i + q; j--) {
                swap(array, j - 1, j);
            }
        }
    }

    public static void shuffleArrayUtil(int[] array, int left, int right){
        if(right - left <= 1) return; //one element in array

        int middle = (left + right)/2;
        int temp = middle + 1;
        int middleM = (left + middle)/2;

        for (int i = middleM + 1; i <= middle; i++){
            swap(array, i, temp++);
        }

        shuffleArrayUtil(array, left, middle);
        shuffleArrayUtil(array, middle+1, right);
    }

    public static Object ShuffleArray(int[] array){
        int size = array.length;
        if(size == 2){
            System.out.println("After:" + Arrays.toString(array));
            return true;
        } else if(size % 2 != 0){
            System.out.println("After:" + Arrays.toString(array));
            return false;
        } else{
            shuffleArrayUtil(array, 0, size-1);
            System.out.println("After:" + Arrays.toString(array));
            return true;
        }


    }

}
