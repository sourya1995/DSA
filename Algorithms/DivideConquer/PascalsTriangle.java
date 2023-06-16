package Algorithms.DivideConquer;

public class PascalsTriangle {
    public static int[] pascalTriangleRecursive(int lineNumber) {
        int currentLineSize = lineNumber;
        int previousLineSize = currentLineSize - 1;
        int[] currentLine = new int[currentLineSize];

        if(lineNumber == 1){
            currentLine[0] = 1;
            return currentLine;
        }

        else {
            int[] previousLine = pascalTriangleRecursive(lineNumber - 1);
            for(int numIndex = 0; numIndex < currentLineSize; numIndex++){
                int leftCoefficient = (numIndex - 1) >= 0 ? previousLine[numIndex - 1] : 0;
                int rightCoefficient = (numIndex) < previousLineSize? previousLine[numIndex] : 0;
                currentLine[numIndex] = leftCoefficient + rightCoefficient;
                System.out.print(leftCoefficient + " " + rightCoefficient);
        }
        System.out.println();
        return currentLine;
    }
    
}
