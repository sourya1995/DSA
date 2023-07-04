package Algorithms.Matrix;

public class IslandPerimeter {
    static int islandPerimeter(Integer[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int result = 0;
        for (int r = 0; r < rows; i++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    result += 4;
                    if (r > 0 && grid[r - 1][c] == 1) {
                        result -= 2;
                    }
                    if (c > 0 && grid[r][c - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }
}
