package Algorithms.DivideConquer;

public class FloorAndCeiling {
    public static int findFloor(int[] arr, int x){
        int left = 0;
        int right = arr.length - 1;
        int floor = -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == x) return arr[mid];
            else if(x < arr[mid]) right = mid - 1;
            else {
                floor = arr[mid];
                left = mid + 1;
            }
        }
        return floor;
    }

    public static int findCeiling(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int ceil = -1;
         while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == x) return arr[mid];
            else if(x < arr[mid]){
                right = mid - 1;
                ceil = arr[mid];
            }
            else left = mid + 1;
        }
        return ceil;
    }

    public static void findFloorCeiling(int[] input, int x, int[] output){
        output[0] = findFloor(input, x);
        output[1] = findFloor(input, x);
    }
    
}
