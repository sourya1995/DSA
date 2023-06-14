public class ZeroOneKnapsack{
    public static int knapSack(int[] profits, int profitsLength, int[] weights, int weightsLength, int capacity, int currentindex) {
        if(capacity <= 0 || currentindex >= profitsLength || currentindex < 0 || weightsLength != profitsLength) 
            return 0;

        int profit1 = 0;
        if(weights[currentindex] <= capacity)
            profit1 = profits[currentindex] + knapSack(profits, profitsLength, weights, weightsLength, capacity - weights[currentindex], currentindex + 1);

        int profit2 = knapSack(profits, profitsLength, weights, weightsLength, capacity, currentindex + 1);

        return Math.max(profit1, profit2);
        }
}