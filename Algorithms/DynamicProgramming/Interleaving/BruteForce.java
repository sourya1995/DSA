package Algorithms.DynamicProgramming.Interleaving;

public class BruteForce {
    public static boolean findSIRecursive(String m, String n, String p, int mIndex, int nIndex, int pIndex){
        if(mIndex == m.length() && nIndex == n.length() && pIndex == p.length()){
            return true;
        }

        if(pIndex == p.length()) return false;
        boolean b1 = false, b2 = false;
        if(mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex))
            b1 = findSIRecursive(m, n, p, mIndex + 1, nIndex, pIndex + 1);

        if(nIndex < n.length() && n.charAt(nIndex) == p.charAt(nIndex))
            b2 = findSIRecursive(m, n, p, mIndex, nIndex + 1, pIndex + 1);

        return b1 || b2;
    }

    public static Object findSI(String m, String n, String p){
        return findSIRecursive(m, n, p, 0, 0, 0);
    }
}
