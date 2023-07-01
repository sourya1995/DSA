package Algorithms.Math;

public class PowerNum {
    static double PowerRec(double x, int n){
        if(n == 0) return 1;

        if(n == 1) return x;

        double temp = PowerRec(x, n/2);

        if(n % 2 == 0) return temp * temp;

        else {
            return x * temp * temp;
        }
    }

    static double power(double x, int n) {
        boolean isNegative = false;
        if(n < 0){
            isNegative = true;
            n *= -1;
        }

        double result = PowerRec(x, n);

        if(isNegative){
            return 1/result;
        }

        return result;
    }
}
