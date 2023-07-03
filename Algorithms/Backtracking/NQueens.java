package Algorithms.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    static boolean isValidMove(int proposedRow, int proposedColumn, List<Integer> solution){
        for(int i=0; i<proposedRow; i++){
            int oldRow = i;
            int oldCol = solution.get(i);

            int diagonalOffset = proposedRow - oldRow;
            if(oldCol == proposedColumn || oldCol == proposedColumn - diagonalOffset || oldCol == proposedColumn + diagonalOffset){
                return false;
            }
        }
        return true;
    }

    static void solveNQueensRecursive(int n, List<Integer> solution, int row, List<List<Integer>> results){
        if(row == n){
            results.add(new ArrayList<Integer>(solution));
            return;
        }

        for(int i=0; i<n; i++){
            if(isValidMove(row, i, solution)){
                solution.set(row, i);
                solveNQueensRecursive(n, solution, row + 1, results);
            }
        }
    }

    static int solveNQueens(int n){
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>(n);
        for(int i=0; i < n; ++i){
            solution.add(-1);
        }

        solveNQueensRecursive(n, solution, 0, results);
        return results.size();
    }
}
