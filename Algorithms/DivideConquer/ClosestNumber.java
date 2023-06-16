package Algorithms.DivideConquer;

public class ClosestNumber {
    //we need to calculate the absolute sum, and then find the minimum value from the target
    public static int closer(int first, int second, int target){
        if(target - first >= second - target)
            return second;
        else 
            return first;
    }
    
    public static int closestNumber(int arr[], int target){
                int n = arr.length;
                if(target <= arr[0])
                    return arr[0];
                
                if(target >= arr[n-1])
                    return arr[n-1];

                int i=0, j = n, mid = 0;

                while(i < j) {
                    mid = (i+j)/2;
                    if(arr[mid] == target){
                        return arr[mid];
                    }

                    if(target < arr[mid])
                    {
                        if(mid > 0 && target > arr[mid - 1])
                            return closer(arr[mid - 1], arr[mid], target);
                            j = mid;
                    }
                    else {
                        if(mid < n - 1 && target < arr[mid + 1])
                            return closer(arr[mid], arr[mid + 1], target);
                        i = mid + 1;
                    }
                }
                return arr[mid];
            }

    }
    

