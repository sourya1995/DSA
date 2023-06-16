package Algorithms.DivideConquer;

public class MissingNumber {
    public static int missingNumber(int[] arr, int size){
        int missing = -1;
        int last = arr[0];
        if(last != 1){
            return 1;
        }

        for(int i = 1; i < size; i++){
            if(arr[i] - last > 1){
                missing = last + 1;
                break;
            }
            last++;
        }
        return missing;
    }

    public static int missingNumberEfficient(int[] arr, int size){
        int leftLimit = 0;
        int rightLimit = size - 1;

        if(arr[leftLimit] != 1)
            return 1;

        while(leftLimit <= rightLimit) {
            int middle = (leftLimit + rightLimit)/2;
            if(arr[middle] != middle + 1 && arr[middle - 1] == middle)
                return middle +1;

            if(arr[middle] != middle + 1)
                rightLimit = middle - 1;
            
            else
                leftLimit = middle + 1;

        }
        return -1;
    } 
    
}
