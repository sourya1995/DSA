package Algorithms.DynamicProgramming;

public class MemoizedFibonacci {
    public static int fib(int n, int lookupTable[]){
        if(lookupTable[n] == -1){
            if(n <= 1){
                lookupTable[n] = n;
            }
            else {
                lookupTable[n] = fib(n -1, lookupTable) + fib(n-2, lookupTable);
            }
        }
        return lookupTable[n];
    }
    
}
