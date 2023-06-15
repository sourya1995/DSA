package Algorithms.DynamicProgramming.ShortestCommonSupersequence;

public class Memoization {
    public static int findSCSLengthRecursive(int[][] lookupTable, String s1, String s2, int i1, int i2) {
        if(i1 == s1.length())
            return s2.length() - i2;
        if(i2 == s2.length())
            return s1.length() - i1;

        if(lookupTable[i1][i2] == 0){
            if(s1.charAt(i1) == s2.charAt(i2))
                lookupTable[i1][i2] = 1 + findSCSLengthRecursive(lookupTable, s1, s2, i1 + 1, i2 + 1);
            else {
                int length1 = 1 + findSCSLengthRecursive(lookupTable, s1, s2, i1, i2 + 1);
                int length2 = 1 + findSCSLengthRecursive(lookupTable, s1, s2, i1 + 1, i2);
                lookupTable[i1][i2] = Math.min(length1, length2);
            }
        }

        return lookupTable[i1][i2];
    }

    public static int findSCSLength(String s1, String s2){
        int[][] lookupTable;
        lookupTable = new int[s1.length()][];
        for(int i = 0; i < s1.length(); i++){
            lookupTable[i] = new int[s2.length()];
            for(int j = 0; j < s2.length(); j++)
                lookupTable[i][j] = 0;
        }
        return findSCSLengthRecursive(lookupTable, s1, s2, 0, 0);
    }
    
}
