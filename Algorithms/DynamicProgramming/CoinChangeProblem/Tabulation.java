package Algorithms.DynamicProgramming.CoinChangeProblem;

public class Tabulation {
    public static int countChange(int denoms[], int denomsLength, int amount)
    if(amount <= 0 || denomsLength <=0) return 0;
    int i, j, x, y;

    int[][] lookupTable = new int[amount + 1][denomsLength];
    for(i = 0; i < denomsLength; i++){
        lookupTable[0][i] = 1;
    }

    for(i = 1; i < amount + 1; i++){
        for(j = 0; j < denomsLength; j++){
            x = (i - denoms[j] >= 0) ? lookupTable[i - denoms[j]][j] : 0;
            y = (j  >= 1) ? lookupTable[i][j-1] : 0;
            lookupTable[i][j] = x + y;
        }
    }
    return lookupTable[amount][denomsLength - 1];
}
