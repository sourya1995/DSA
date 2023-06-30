package Algorithms.Arrays;

public class SortColors {
    public static void SortColors(int[] arr){
        int start = 0;
        int current = 0;
        int end = arr.length - 1;
        int temp;

        while(current <= end){
            if(arr[current] == 0){
                temp = arr[start];
                arr[start++] = arr[current];
                arr[current++] = temp;
            } else if(arr[current] == 2){
                temp = arr[current];
                arr[current] = arr[end];
                arr[end--] = temp;
            } else {
                current++;
            }


        }
    }
}
