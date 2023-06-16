package Algorithms.DynamicProgramming.EditDistance;

public class Memoization {
    public static int min(int a, int b, int c){
        if(a <= b && a <= c) return a;
        if(b <= a && b <= c) return b;
        else return c;
    }

    public static int minEditDistRec(String str1, String str2, int m, int n, int[][] lookupTable) {
        if(m == 0) return n;
        if(n == 0) return m;

        if(lookupTable[m - 1][n - 1] != -1)
            return lookupTable[m - 1][n - 1];

        if(str1.charAt(m - 1) == str2.charAt(n - 1))
            return lookupTable[m - 1][n - 1] = minEditDistRec(str1, str2, m - 1, n - 1, lookupTable);

                return lookupTable[m - 1][n - 1] = 1 + min(minEditDistRec(str1, str2, m, n - 1, lookupTable),
                minEditDistRec(str1, str2, m - 1, n, lookupTable),
                minEditDistRec(str1, str2, m, n - 1, lookupTable));
    }

    public static int minEditDistDP(String str1, String str2, int m, int n) {
       int[][] lookupTable = new int[m][];
       for(int i = 0; i < m; i++){
        lookupTable[i] = new int[n];
        for(int j = 0; j < n; j++){
            lookupTable[i][j] = -1;
        }
       }
       return minEditDistRec(str1, str2, m, n, lookupTable);
    }

}
