package Algorithms.DynamicProgramming.EditDistance;

public class MemoizationRedux {
    static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);

    }

    public static int levenshteinDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        if (str1 == str2)
            return 0;

        if (m == 0)
            return n;

        if (n == 0)
            return m;

        int[][] d = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            d[i][0] = i;
        }

        for (int j = 1; j <= n; j++) {
            d[0][j] = j;
        }

        int cost;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    cost = 0;
                else
                    cost = 1;

                d[i][j] = minimum(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + cost);
            }
        }
        return d[m][n];
    }
}
