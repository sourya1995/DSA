package Algorithms;

public class SearchInsertPosition {
    public static int insertPosition(int[] arr, int target){
        int arrSize = arr.length;
        if(arrSize < 1)
            return -1;

        int start = 0;
        int end = arrSize - 1;
        int mid = 0, pos = 0;

        while(start <= end){
            mid = start + (end - start)/2;
            if(arr[mid] == target)
            return mid;

            else if(arr[mid] > target){
                end = mid - 1;
                pos = mid;
            }

            else {
                start = mid + 1;
                pos = mid + 1;
            }
        }
        return pos;
    }
    
}
