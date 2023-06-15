package Algorithms.DynamicProgramming.ShortestCommonSupersequence;

public class BruteForce {
    public static int findSCSLengthRecursive(String s1, String s2, int i1, int i2){
        if(i1 == s1.length())
            return s2.length() - i2;
        if(i2 == s2.length())
            return s1.length() - i1;

        if(s1.charAt(i1)==s2.charAt(i2))
            return 1 + findSCSLengthRecursive(s1, s2, i1 + 1, i2 + 1);

        int length1 = 1 + findSCSLengthRecursive(s1, s2, i1, i2 + 1);
        int length2 = 1 + findSCSLengthRecursive(s1, s2, i1 +1, i2);

        return Math.min(length1, length2);
    }

    public static int findSCSLength(String s1, String s2){
        return findSCSLengthRecursive(s1, s2, 0, 0);
    }
}
