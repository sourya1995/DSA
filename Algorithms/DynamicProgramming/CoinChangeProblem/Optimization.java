package Algorithms.DynamicProgramming.CoinChangeProblem;

public class Optimization {
    public static int countChange(int denoms[], int amount){
        int denomsLength = denoms.length;
        if(denomsLength <=0 || amount <= 0) return 0;

        int[]lookupTable = new int[amount + 1];

        for(int i = 0; i < amount+1; i++){
            lookupTable[i] = 0;
        }

        lookupTable[0] = 1;

        for(int i = 0; i < denomsLength; i++)
            for(int j = denoms[i]; j <= amount; j++)
            lookupTable[j] = lookupTable[j - denoms[i]];

            return lookupTable[amount];
    }

    
    
}
