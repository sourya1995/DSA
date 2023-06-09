package Algorithms;

public class SearchInSortedMatrix {
    public static Object searchKey(int[][] matrix, int numberOfRows, int numberOfColumns, int target){
        for(int i = 0; i < numberOfRows; i++){
            for(int j = 0; j < numberOfColumns; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public static Object findKey(int[][] matrix, int numberOfRows, int numberOfColumns, int target){
        int i = numberOfColumns - 1;
        int j = 0;

        while(i >= 0 && j < numberOfColumns){
            if(matrix[i][j] == target)
                return true;
            if(target > matrix[i][j])
                j++;
            else
                i--;
            
        }
        
    return false;
    }

    public static Object findKeyBinarySearch(int[][] matrix, int numberOfRows, int numberOfColumns, int target){
        int min = 0;
        int max = numberOfRows * numberOfColumns - 1;

        while(min <= max){
            int middle = (min + max) / 2;
            int row = middle / numberOfColumns;
            int column = middle % numberOfColumns;

            if(target < matrix[row][column]){
                max = middle - 1;
            }

            else if(target > matrix[row][column]){
                min = middle + 1;
            }

            else {
                return true;
            }
        }
        return false;
    }

}

    

