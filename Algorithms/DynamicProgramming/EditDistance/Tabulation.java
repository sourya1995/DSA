package Algorithms.DynamicProgramming.EditDistance;

public class Tabulation {
    public static int min(int a, int b, int c) {
        if (a <= b && a <= c)
            return a;
        if (b <= a && b <= c)
            return b;
        else
            return c;
    }

    public static int minEditDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {

            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else
                    dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }
        return dp[m][n];

    }
}
