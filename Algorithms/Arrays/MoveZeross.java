package Algorithms.Arrays;

public class MoveZeross {
    public static void moveZerosToLeft(int[] nums){
        if(nums.length < 1){
            return;
        } 

        int numsLength = nums.length;

        int writeIndex = numsLength - 1;
        int readIndex = numsLength - 1;

        while(readIndex >= 0){
            if(nums[readIndex] != 0){
                nums[writeIndex] = nums[readIndex];
                writeIndex--;
            }
            readIndex--;
        }

        while(writeIndex >= 0){
            nums[writeIndex] = 0;
            writeIndex--;
        }
    }
}
