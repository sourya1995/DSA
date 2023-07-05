package Algorithms.DynamicProgramming.MaxRuns;

public class BruteForce {
    public static int scoringOptions(int n){
        if(n < 0) return 0;
        if(n == 0) return 1;

        return scoringOptions(n - 1) + scoringOptions(n - 2) + scoringOptions(n - 4);
    }
}
