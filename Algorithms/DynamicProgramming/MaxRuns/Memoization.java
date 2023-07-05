package Algorithms.DynamicProgramming.MaxRuns;

import java.util.Arrays;

public class Memoization {
    private static int DPHelper(int n, int[] Vector){
        if(n < 0) return 0;
        if(Vector[n] != -1){
            return Vector[n];
        }

        return Vector[n] = DPHelper(n - 1, Vector) + DPHelper(n - 2, Vector) + DPHelper(n - 4, Vector);
    }

    public static int scoringOptions(int n){
        int[] Vector = new int[n + 1];
        Arrays.fill(Vector, -1);

        Vector[0] = 1;
        return DPHelper(n, Vector);
    }
}
