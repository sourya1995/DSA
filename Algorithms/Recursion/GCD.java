package Algorithms.Recursion;

public class GCD {
    public static int gcd(int x, int y) {
        if(x == y) return x;
        if(x > y) return gcd(x - y, y);
        else return gcd(x, y-x);
}
