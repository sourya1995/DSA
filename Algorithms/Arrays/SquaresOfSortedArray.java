package Algorithms.Arrays;

public class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = nums.length - 1;
        int square;
        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            }

            else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }
}
