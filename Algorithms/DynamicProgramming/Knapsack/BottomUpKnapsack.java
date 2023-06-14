package Algorithms.DynamicProgramming.Knapsack;

public class BottomUpKnapsack {
    public static int knapsack(int profits[], int profitsLength, int weights[],
            int weightsLength, int capacity) {
        if (capacity <= 0 || profitsLength == 0 || weightsLength != profitsLength)
            return 0;

        int i, w;
        int[][] lookupTable = new int[profitsLength + 1][capacity + 1];
        for (i = 0; i <= profitsLength; i++) {
            for (w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    lookupTable[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    lookupTable[i][w] = Math.max(profits[i - 1] + lookupTable[i - 1][w - weights[i - 1]],
                            lookupTable[i - 1][w]);
                } else {
                    lookupTable[i][w] = lookupTable[i - 1][w];
                }
            }
        }

        return lookupTable[profitsLength][capacity];
    }

    public static int knapSack(int[] profits, int profitsLength, int[] weights, int weightsLength, int capacity){
        if(capacity <= 0 || profitsLength == 0 || weightsLength != profitsLength)
            return 0;

        int[] lookupTable = new int[capacity + 1];

        for(int c = 0; c <= capacity; c++){
            if(weights[0] <= c)
                lookupTable[c] = profits[0];
        }

        for(int i = 1; i < profitsLength; i++){
            for(int c = capacity; c >= 0; c-- ){
                int profit1 = 0, profit2 = 0;
                if(weights[i] <= c){
                    profit1 = profits[i] + lookupTable[c - weights[i]];
                    profit2 = lookupTable[c];
                    lookupTable[c] = Math.max(profit1, profit2);
                }
            }

        }
        return lookupTable[capacity];
    }
}
