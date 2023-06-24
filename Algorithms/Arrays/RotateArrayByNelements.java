package Algorithms.Arrays;

import java.util.List;

public class RotateArrayByNelements {
    static void ReverseArray(List<Integer> nums, int start, int end){
        while (start < end){
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            ++start;
            --end;
        }
    }

    static void RotateArrayByNelements(List<Integer> nums, int n) {
        int len = nums.size();
        n = n % len;
        if(n < 0){
            n = n + len;
        }

        ReverseArray(nums, 0, len - 1);
		ReverseArray(nums, 0, n - 1);
		ReverseArray(nums, n, len - 1);
    }
}
