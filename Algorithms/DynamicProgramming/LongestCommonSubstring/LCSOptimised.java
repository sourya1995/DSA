package Algorithms.DynamicProgramming.LongestCommonSubstring;

public class LCSOptimised {
    public static int longestCommonSubstringLength(String s1, String s2) {
        int[][] lookupTable = new int[s1.length() + 1][];
        for (int i = 0; i < s1.length(); i++)
            lookupTable[i] = new int[s2.length() + 1];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                lookupTable[i][j] = 0;
            }
        }

        int maxLength = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                lookupTable[i % 2][j] = 0;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lookupTable[i % 2][j] = 1 + lookupTable[(i - 1) % 2][j - 1];
                    maxLength = Math.max(maxLength, lookupTable[i % 2][j]);
                }
            }

        }
        return maxLength;

    }
}
