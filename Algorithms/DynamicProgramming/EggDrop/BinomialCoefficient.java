package Algorithms.DynamicProgramming.EggDrop;

public class BinomialCoefficient {
    public static int binomialCoeff(int x, int n, int k){
        int sum = 0, term = 1;
        for(int i = 1; i <= n && sum < k; ++i){
            term *= x - i + 1;
            term /= i;
            sum += term;
        }
        return sum;
    }

    public static int eggDrop(int eggs, int floors){
        if(eggs <= 0) return 0;
        if(floors == 1 || floors == 0) return floors;
        if(eggs == 1) return floors;
        int low = 1, high = floors;

        while(low < high){
            int mid = (low + high) / 2;
            if(binomialCoeff(mid, eggs, floors) < floors)
                low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
