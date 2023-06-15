package Algorithms.DynamicProgramming.LongestPalindromicSubsequence;

public class Tabulation {
    public static int LPSLength(String st){
        int size = st.length();
        int[][] lookupTable;
        lookupTable = new int [size][];
        for(int i = 0; i < size; i++){
            lookupTable[i] = new int[size];
            for(int j = 0; j < size; j++)
            lookupTable[i][j] = 0;
        }

        for(int i = 0; i < size; i++)
            lookupTable[i][i] = 1;

        for (int startIndex = size - 1; startIndex >= 0; startIndex--){
            for (int endIndex = startIndex + 1; endIndex < size; endIndex++){
                if(st.charAt(startIndex) == st.charAt(endIndex))
                    lookupTable[startIndex][endIndex] = 2 + lookupTable[startIndex + 1][endIndex - 1];
                else
                    lookupTable[startIndex][endIndex] = Math.max(lookupTable[startIndex + 1][endIndex], lookupTable[startIndex][endIndex - 1]);
            }
        }
        return lookupTable[0][size - 1];
    }
    
}
