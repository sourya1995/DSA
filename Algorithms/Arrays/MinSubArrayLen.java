package Algorithms.Arrays;

public class MinSubArrayLen {
    public static int minSubArrayLen(int s, int[] nums){
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while (sum >= s){
                int currentSubArraySize = (i + 1) - left;
                result = Math.min(result, currentSubArraySize);
                sum -= nums[left++];
            }
        }

        if(result != Integer.MAX_VALUE){
            return result;
        } else {
            return 0;
        }
    }
}
