package Algorithms.DynamicProgramming.MaxRuns;

import java.util.Arrays;

public class Tabulation {
    public static int scoringOptions(int n){
        int[] Vector = new int[n + 1];
        Arrays.fill(Vector, -1);

        Vector[0] = 1;
        int s4, s2, s1 = 0;

        for(int i = 0; i <= n; i++){
            s1 = i - 1 < 0 ? 0 : Vector[i - 1];
            s2 = i - 2 < 0 ? 0 : Vector[i - 2];
            s4 = i -4 < 0 ? 0 : Vector[i - 4];

            Vector[i] = s1 + s2 + s4;
        }
        return Vector[n];
    }
}
