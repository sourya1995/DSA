package Algorithms.DynamicProgramming.CoinChangeProblem;

public class Memoization {
    public static int countChangeRec(int denoms[], int denomsLength, int amount, int[][] lookupTable) {
        if (amount == 0)
            return 1;
        if (amount < 0 || denomsLength == 0)
            return 0;
        if (lookupTable[denomsLength - 1][amount] != 0)
            return lookupTable[denomsLength - 1][amount];
        lookupTable[denomsLength - 1][amount] = countChangeRec(denoms, denomsLength - 1, amount, lookupTable)
                + countChangeRec(denoms, denomsLength, amount - denoms[denomsLength - 1], lookupTable);
        return lookupTable[denomsLength - 1][amount];

    }

    public static int countChangeRec(int denoms[], int denomsLength, int amount) {
        int[][] lookupTable;
        lookupTable = new int[denomsLength][];
        for (int i = 0; i < denomsLength; i++) {
            lookupTable[i] = new int[amount + 1];
            for (int j = 0; j < amount + 1; j++) {
                lookupTable[i][j] = 0;
            }
        }
        return countChangeRec(denoms, denomsLength, amount, lookupTable);
    }
}
