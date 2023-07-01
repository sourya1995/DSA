package Algorithms.Math;

import java.util.List;

public class MissingNumber {
    static int findMissing(List<Integer> input){
        int actualSum = 0;
        for(Integer x: input){
            actualSum += x;
        }
        int n = input.size();
        int sumOfN = (n * (n + 1)) / 2;
        return sumOfN - actualSum;
    }
}
