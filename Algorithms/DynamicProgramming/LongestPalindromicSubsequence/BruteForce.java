package Algorithms.DynamicProgramming.LongestPalindromicSubsequence;

public class BruteForce {
    public static int LPSLengthRec(String st, int startIndex, int endIndex) {
        if(startIndex > endIndex) return 0;
        if(startIndex == endIndex) return 1;
        if(st.charAt(startIndex) == st.charAt(endIndex))
            return 2 + LPSLengthRec(st, startIndex + 1, endIndex - 1);
        
        int c1 = LPSLengthRec(st, startIndex + 1, endIndex);
        int c2 = LPSLengthRec(st, startIndex, endIndex - 1);
        return Math.max(c1, c2);
}

public static int LPSLength(String st){
    return LPSLengthRec(st, 0, st.length() - 1);
}
