package Algorithms.DynamicProgramming.LongestCommonSubstring;

public class LCSBruteForce {
    public static int LongestCommonSubstringRecursive(String s1, String s2, int i1, int i2, int count) {
        if(i1 == s1.length() || i2 == s2.length())
            return count;

        if(s1.charAt(i1) == s2.charAt(i2))
            count = LongestCommonSubstringRecursive(s1, s2, i1 + 1, i2 + 1, count + 1);
        
        int c1 = LongestCommonSubstringRecursive(s1, s2, i1, i2+1, 0);
        int c2 = LongestCommonSubstringRecursive(s1, s2, i1 +1, i2, 0);

        return Math.max(c1, c2);
    
}

public static int LongestCommonSubstring(String s1, String s2){
    return LongestCommonSubstringRecursive(s1, s2, 0, 0, 0);
}
