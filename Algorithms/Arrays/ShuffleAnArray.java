package Algorithms.Arrays;

import java.util.Random;

public class ShuffleAnArray {
    private int[] original;
    Random rand;

    public ShuffleAnArray(int[] nums) {
        original = nums;
        rand = new Random(System.currentTimeMillis());
    }
    
    public int[] reset() {
        return original;
    }

    private void swapAt(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public int[] shuffle() {
        int[] shuffled = new int[original.length];
        System.arraycopy(original, 0, shuffled, 0, original.length);
        int leftSize = original.length;
        for(int i = original.length - 1; i >= 0; i--){
            int j = rand.nextInt(200000) % leftSize;
            swapAt(shuffled, i, j);
            leftSize--;
        }
        return shuffled;
    }
}
