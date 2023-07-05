package Algorithms.DynamicProgramming.EditDistance;

public class TabulationRedux {
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

        int[] d1 = new int[n + 1];
        int[] d2 = new int[n + 1];

        for (int i = 0; i < n; i++)
            d1[i] = i;

        int cost;
        for (int i = 0; i < m; i++) {
            d2[0] = i + 1;

            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j))
                    cost = 0;
                else
                    cost = 1;
                d2[j + 1] = minimum(d2[j] + 1, d2[j + 1] + 1, d2[j] + cost);
            }

            for (int j = 0; j <= n; j++)
                d1[j] = d2[j];
        }
        return d2[n];
    }
}
