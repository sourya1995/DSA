package Algorithms.DynamicProgramming.Interleaving;

public class Tabularization {
    public static Object findSI(String m, String n, String p) {
        boolean[][] lookupTable = new boolean[m.length() + 1][];

        for (int i = 0; i < m.length() + 1; i++) {
            lookupTable[i] = new boolean[n.length() + 1];
        }

        if (m.length() + n.length() != p.length())
            return false;

        for (int mIndex = 0; mIndex < m.length(); mIndex++) {
            for (int nIndex = 0; nIndex < n.length(); nIndex++) {
                if (mIndex == 0 && nIndex == 0)

                    lookupTable[mIndex][nIndex] = true;

                else if (mIndex == 0 && n.charAt(nIndex - 1) == p.charAt(mIndex + nIndex - 1))

                    lookupTable[mIndex][nIndex] = lookupTable[mIndex][nIndex - 1];

                else if (nIndex == 0 && m.charAt(nIndex - 1) == p.charAt(mIndex + nIndex - 1))

                    lookupTable[mIndex][nIndex] = lookupTable[mIndex - 1][nIndex];

                else {
                    if (mIndex > 0 && m.charAt(mIndex - 1) == p.charAt(mIndex + nIndex - 1))

                        lookupTable[mIndex][nIndex] = lookupTable[mIndex - 1][nIndex];

                    if (nIndex > 0 && n.charAt(nIndex - 1) == p.charAt(mIndex + nIndex - 1))
                        lookupTable[mIndex][nIndex] |= lookupTable[mIndex - 1][nIndex];
                }

            }
        }
        return lookupTable[m.length()][n.length()];
    }
}
