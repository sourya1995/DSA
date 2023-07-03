package Algorithms.Matrix;

class Pair {
    public Integer first;
    public Integer second;

    public Pair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }
}

public class SearchMatrix {
    public static Pair searchInMatrix(int[][] matrix, int value){
        int M = matrix.length;
        int N = matrix[0].length;

        int i = 0, j = N - 1;

        while(i < M && j >= 0) {
            if(matrix[i][j] == value){
                return new Pair(i, j);
            } else if(value < matrix[i][j]){
                --j;
            } else {
                ++i;
            }
        }

        return new Pair(-1, -1);
    }
}
