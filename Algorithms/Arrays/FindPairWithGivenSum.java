package Algorithms.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPairWithGivenSum {
    static boolean findSumOfTwo(int[] nums, int val) {
        Set<Integer> foundValues = new HashSet<Integer>();
        for (int ele : nums) {
            if (foundValues.contains(val - ele)) {
                return true;
            }
            foundValues.add(ele);
        }
        return false;
    }

    static boolean findSumOfTwoArray(int[] nums, int val) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == val) {
                return true;
            }

            if (sum < val) {
                ++i;
            }

            if (sum > val) {
                --j;
            }
        }
        return false;
    }
}
