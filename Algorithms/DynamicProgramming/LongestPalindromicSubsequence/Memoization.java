package Algorithms.DynamicProgramming.LongestPalindromicSubsequence;

public class Memoization {
    public static int LPSLengthRec(int[][] lookupTable, String st, int startIndex, int endIndex) {
        if(startIndex > endIndex) return 0;
        if(startIndex == endIndex) return 1;

        if(lookupTable[startIndex][endIndex] == 0){
            if(st.charAt(startIndex) == st.charAt(endIndex)){
                lookupTable[startIndex][endIndex] = 2 + LPSLengthRec(lookupTable, st, startIndex+1, endIndex-1);
            }else{
                int c1 = LPSLengthRec(lookupTable, st, startIndex+1, endIndex);
                int c2 = LPSLengthRec(lookupTable, st, startIndex, endIndex-1);
                lookupTable[startIndex][endIndex] = Math.max(c1, c2);
            }
        }
        return lookupTable[startIndex][endIndex];
    }

    public static int LPSLength(String st){
        int[][] lookupTable;

        lookupTable = new int[st.length()][];
        for(int i=0; i < st.length(); i++){
            lookupTable[i] = new int[st.length()];
            for(int j = 0; j < st.length(); j++)
                lookupTable[i][j] = 0;
        }
        return LPSLengthRec(lookupTable, st, 0, st.length()-1);
    }
    
}
