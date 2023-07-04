package Algorithms.DynamicProgramming;

public class FindMaxSubsequence {
    static int findMaxSubsequence(int[] nums){
        if (nums == null){
            return 0;
        }

        int size = nums.length;

        if(size == 0){
            return 0;
        }

        if(size == 1){
            return nums[0];
        }

        int prevOfPrev = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        for(int i = 2; i < size; i++){
            int curr = Math.max(nums[i], Math.max(prev, prevOfPrev + nums[i]));
            prevOfPrev = prev;
            prev = curr;
        }
        return prev;

    }
}
