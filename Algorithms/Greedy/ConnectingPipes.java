package Algorithms.Greedy;

import java.util.Arrays;

public class ConnectingPipes {
    public static int minCost(int[] pipes) {
        int cost = 0;
        int n = pipes.length;
        for (int i = 0; i < n - 1; i++) {
            Arrays.sort(pipes);
            int prev_cost = cost;
            cost = (pipes[i] + pipes[i + 1]);
            pipes[i + 1] = cost;
            cost = cost + prev_cost;
        }
        return cost;

    }

    public static int minCostHeap(int[] pipes, int n) {
        int cost = 0;
        int minimum, secondMinimum;
        MinHeap minHeap = new MinHeap(pipes, n);

        while (!minHeap.SizeIsOne()) {
            minimum = minHeap.extractMin();
            secondMinimum = minHeap.extractMin();
            cost += (minimum + secondMinimum);
            minHeap.insertKey(minimum + secondMinimum);
        }

        return cost;
    }

}
