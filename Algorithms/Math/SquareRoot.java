package Algorithms.Math;

public class SquareRoot {
    private static final double EPSILON = 0.0001;

    public static double squareRoot(double num) {
        double low = 0;
        double high = 1 + num / 2;

        while (low < high) {
            double mid = (low + high) / 2;
            double sqr = mid * mid;

            double diff = Math.abs(num - sqr);
            if (diff < EPSILON) {
                return mid;
            }

            if (sqr < num) {
                low = mid;
            }

            else {
                high = mid;
            }
        }
        return -1;
    }
}
