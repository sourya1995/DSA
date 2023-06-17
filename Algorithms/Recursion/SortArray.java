package Algorithms.Recursion;

public class SortArray {
    public static void sortArray(int[] array, int n){
        if(n == 1) {
            return;
        }

        for(int i = 0; i < n-1; i++) {
            if(array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        sortArray(array, n - 1);
    }
}
