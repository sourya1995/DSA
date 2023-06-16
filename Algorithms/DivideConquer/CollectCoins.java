package Algorithms.DivideConquer;

public class CollectCoins {
    public static int minimumStepsUtil(int left, int right, int h, int height[]){
        if(left >= right) return 0;

        int min = left;
        for(int i = left; i < right; i++)
        {
            if(height[i] < height[min])
            min = i;
        }

        return Math.min(right - left, minimumStepsUtil(left, min, height[min], height) + minimumStepsUtil(min + 1, right, height[min], height) + height[min] - h);
    }

    public static int minimumSteps(int height[], int N){
        return minimumStepsUtil(0, N, 0, height);
    }
    
}
