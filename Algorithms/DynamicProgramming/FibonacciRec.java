package Algorithms.DynamicProgramming;

public class FibonacciRec {
    public static int fib(int i){
        if(i <= 1){
            return i;
      
        }
        return fib(i - 1) + fib(i - 2);
    }
    
}
