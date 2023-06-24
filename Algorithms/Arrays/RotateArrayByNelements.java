package Algorithms.Arrays;

import java.util.ArrayList;
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

    static void RotateArrayByN(List<Integer> nums, int n){
        int len = nums.size();
        n = n %len;
        if(n < 0) {
            n = n + len;
        }

        List<Integer> temp = new ArrayList<Integer>();

        for (int i = len - n; i < len; i++) {
            temp.add(nums.get(i));
        }

        for (int i = len - 1; i>=n; i--){
            nums.set(i, nums.get(i-n));
        }

        for(int i = 0; i < n; i++){
            nums.set(i, temp.get(i));
        }
    }
}
