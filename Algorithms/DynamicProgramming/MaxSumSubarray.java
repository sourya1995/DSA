package Algorithms.DynamicProgramming;

public class MaxSumSubarray {
    static int findMaxSumSubarray(int[] nums){
        if(nums.length < 1) {
            return 0;
        }

        int currSubarrMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++){
            if(currSubarrMax < 0){
                currSubarrMax = nums[i];
            }

            else {
                currSubarrMax = currSubarrMax + nums[i];
            }

            if(currSubarrMax > globalMax){
                globalMax = currSubarrMax;
            }
        }
        return globalMax;
    }
}
