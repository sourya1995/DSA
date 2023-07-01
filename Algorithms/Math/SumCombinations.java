package Algorithms.Math;

import java.util.ArrayList;

public class SumCombinations {
    static void printAllSumRec(int target, int currentSum, int start, ArrayList<Integer> result,
            ArrayList<ArrayList<Integer>> output) {
        if (currentSum == target) {
            ArrayList<Integer> resultCopy = new ArrayList<>();
            resultCopy.addAll(result);
            output.add(resultCopy);
        }

        for (int i = start; i < target; i++) {
            int tempSum = currentSum + i;

            if (tempSum <= target) {
                result.add(i);
                printAllSumRec(target, tempSum, i, result, output);
                result.remove(result.size() - 1);
            } else {
                return;
            }
        }
    }

    static ArrayList<ArrayList<Integer>> printAllSum(int target) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        printAllSumRec(target, 0, 1, result, output);
        return output;
    }
}
