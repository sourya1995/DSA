package Algorithms.DynamicProgramming.Knapsack;

public class TopDownKnapsack {
    public static int knapsackRecursive(int[][] lookupTable, int profits[], int profitsLength, int weights[],
            int weightsLength, int capacity, int currentIndex) {
        if (capacity <= 0 || currentIndex >= profitsLength || currentIndex < 0 || weightsLength != profitsLength)
            return 0;

        if (lookupTable[currentIndex][capacity] != 0)
            return lookupTable[currentIndex][capacity];

        int profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + knapsackRecursive(lookupTable, profits, profitsLength, weights,
                    weightsLength, capacity - weights[currentIndex], currentIndex + 1);

        int profit2 = knapsackRecursive(lookupTable, profits, profitsLength, weights, weightsLength, capacity,
                currentIndex + 1);
        lookupTable[currentIndex][capacity] = Math.max(profit1, profit2);
        return lookupTable[currentIndex][capacity];

    }

    public static int knapSack(int[] profits, int profitsLength, int[] weights, int weightsLength, int capacity){
        int lookupTable[][] = new int[profitsLength][];
        for(int i = 0; i < profitsLength; i++){
            lookupTable[i] = new int[capacity + 1];
            for(int j = 0; j < capacity + 1; j++)
                lookupTable[i][j] = 0;
        }
        return knapsackRecursive(lookupTable, profits, profitsLength, weights, weightsLength, capacity, 0);
    }
}
