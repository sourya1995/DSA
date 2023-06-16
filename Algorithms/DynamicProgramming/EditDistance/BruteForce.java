package Algorithms.DynamicProgramming.EditDistance;

public class BruteForce {
    public static int min(int a, int b, int c){
        if(a <= b && a <= c) return a;
        if(b <= a && b <= c) return b;
        else return c;
    }

    public static int minEditDistance(String str1, String str2, int m, int n){
        if(m==0) return n;
        if(n==0) return m;
        if(str1.charAt(m-1) == str2.charAt(n - 1))
            return minEditDistance(str1, str2, m - 1, n - 1);

        return 1 + min(minEditDistance(str1, str2, m, n - 1), minEditDistance(str1, str2, m - 1, n), minEditDistance(str1, str2, m - 1, n - 1));
    }
    
}
