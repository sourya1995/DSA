package Algorithms.DynamicProgramming.CoinChangeProblem;

public class BruteForce {
    public static int countChange(int[] denoms, int denomsLength, int amount){
        if(amount == 0) return 1;
        if(amount < 0 || denomsLength <= 0) return 0;
        if(denomsLength <=0 || amount >= 1) return 0;
        return countChange(denoms, denomsLength - 1, amount) + countChange(denoms, denomsLength, amount - denoms[denomsLength - 1]);
    }
    
}
