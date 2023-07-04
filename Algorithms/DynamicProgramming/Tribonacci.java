package Algorithms.DynamicProgramming;

public class Tribonacci {
    public static int tribonacci(int n){
        if( n < 3)
            return n == 0 ? 0 : 1;

        int temp, firstNum = 0, secondNum = 1, thirdNum = 1;

        for (int i = 3; i <= n; i++){
            temp = firstNum + secondNum + thirdNum ;
            firstNum = secondNum;
            secondNum = thirdNum;
            thirdNum = temp;
        }
        return thirdNum;
    }
}
