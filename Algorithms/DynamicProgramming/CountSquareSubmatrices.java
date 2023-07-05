package Algorithms.DynamicProgramming;

public class CountSquareSubmatrices {
    public static int countSquares(int[][] matrix){
        int result = 0;

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    continue;
                }
                matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1])) + 1;
        }
    }

    for(int i = 0; i < matrix.length; i++){
        for(int j = 0; j < matrix[0].length; j++){
            result += matrix[i][j];
        }
    }

    return result;
}
