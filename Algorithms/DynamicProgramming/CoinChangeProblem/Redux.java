package Algorithms.DynamicProgramming.CoinChangeProblem;

public class Redux {
    static int solveCoinChange(int[] denominations, int amount){
        if(amount < 0){
            return 0;
        }

        int[] solution = new int[amount + 1];
        solution[0] = 1;
        for(int denomination : denominations){
            for(int i = denomination; i < (amount + 1); i++){
                solution[i] += solution[i - denomination];
            }
        }
        return solution[amount];
    }
}
