package Algorithms.Arrays;

public class FindLowHighIndex {
    public static int findLowIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int mid = high/2;

        while(low <= high){
            int midElem = nums[mid];

            if(midElem < target){
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }

            mid = low + (high - low) / 2;
        }

        if(low < nums.length && nums[low] == target){
            return low;
        }

        return -1;
    }

    public static int findHighIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int mid = high/2;

        while(low <= high){
            int midElem = nums[mid];

            if(midElem <= target){
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }

            mid = low + (high - low) / 2;
        }

        if(high == -1){
            return high;
        }

        if(high < nums.length && nums[high] == target){
            return high;
        }

        return -1;
    }
}
