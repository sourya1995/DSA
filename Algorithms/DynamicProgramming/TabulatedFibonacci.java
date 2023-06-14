package Algorithms.DynamicProgramming;

public class TabulatedFibonacci {
    public static int fib(int n, int[] lookupTable){
        lookupTable[0] = 0;
        lookupTable[1] = 1;

        for(int i = 2; i <= n; i++){
            lookupTable[i] = lookupTable[i-1] + lookupTable[i-2];
        }
        return lookupTable[n];
    }

    public static int fib2(int n){
        if(n <= 1){
            return n;
        }

        int secondLast = 0;
        int last = 1;
        int current = 0;
        for(int i = 2; i <= n; i++){
            current = secondLast + last;
            secondLast = last;
            last = current;
        }
        return current;

    }
    
}
