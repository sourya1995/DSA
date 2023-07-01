package Algorithms.Math;

public class IntegerDivide {
    public static int divideInteger(int dividend, int divisor) {
        if (divisor == 0) {
            return -1;
        }

        if (dividend < divisor) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Overflow condition
        }

        else if (dividend == divisor) {
            return 1;
        }

        else if (divisor == 1) {
            return dividend;
        }

        int q = 1;
        int val = divisor;

        while (val < dividend) {
            val <<= 1;
            q <<= 1;
        }

        if (val > dividend) {
            val >>= 1;
            q >>= 1;

            return q + divideInteger(dividend - val, divisor);
        }

        return q;
    }
}
