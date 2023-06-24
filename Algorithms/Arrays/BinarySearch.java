package Algorithms.Arrays;

public class BinarySearch {
    static int binarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) return mid;

            else if(target < nums[mid]) return high = mid - 1;

            else if(target > nums[mid]) return low = mid + 1;

            else return -1;
        }
        return -1;
    }

    static int binarySearchRecursive(int[] nums, int target, int low, int high){
        if(low > high) return -1;

        int mid = low + (high - low) / 2;

        if(nums[mid] == target) return mid;

        else if(target < nums[mid]) return binarySearchRecursive(nums, target, low, mid - 1);

        else if(target > nums[mid]) return binarySearchRecursive(nums, target, mid + 1, high);

        else return -1;
    }
}
