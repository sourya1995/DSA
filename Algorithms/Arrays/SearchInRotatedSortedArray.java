package Algorithms.Arrays;

public class SearchInRotatedSortedArray {
    static int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end)
            return -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    static int binarySearchRecursive(int[] nums, int start, int end, int target){
        if(start > end) return -1;

        int mid = start + (end - start)/2;

        if(nums[mid] == target) return mid;

        if(nums[start] <= nums[mid]){
            if(nums[start] <= target && target < nums[mid]){
                return binarySearch(nums, start, mid - 1, target);
            }

            else {
                return binarySearch(nums, end + 1, end, target)
            }
        }

        else {
            if(nums[mid] <= target && target <= nums[end]){
                return binarySearch(nums, mid + 1, end, target)
            }

            else {
                return binarySearch(nums, start, mid - 1, target)
            }
        }
        return -1;
    }

    static int binarySearchRotated(int[] nums, int target){
        return binarySearch(nums, 0, nums.length - 1, target);
    }

}
