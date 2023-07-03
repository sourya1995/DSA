package Algorithms.Arrays;

import java.util.HashSet;

public class SumOfThree {
    public static boolean findSumOfThree(int nums[], int requiredSum) {
        HashSet<Integer> hashset = new HashSet<Integer>();
        int currentSum, tripleNeeded;
        for (int i = 0; i < nums.length - 1; i++) {
            hashset.clear();
            currentSum = requiredSum - nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                tripleNeeded = currentSum - nums[j];

                if (hashset.contains(tripleNeeded)) {
                    return true;
                }

                hashset.add(nums[j]);
            }
        }
        return false;
    }
}
