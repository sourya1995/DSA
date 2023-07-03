package Algorithms.Matrix;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes {
    static void makeZeroes(int[][] matrix){
        if(matrix.length == 0) return;

        Set<Integer> zeroRows = new HashSet<Integer>();
        Set<Integer> zeroCols = new HashSet<Integer>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 0){
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        for(int r: zeroRows){
            for(int c = 0; c < cols; c++){
                matrix[r][c] = 0;
            }
        }

        for(int c : zeroCols){
            for(int r = 0; r < rows; ++r){
                matrix[r][c] = 0;
            }
        }
    }
}
