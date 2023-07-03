package Algorithms.Backtracking;

import java.sql.Array;
import java.util.ArrayList;

public class GenerateParentheses {
    static void backtrack(int n, int openBracesCount, int closeBracesCount, ArrayList<Character> output, ArrayList<String> result){
        if(openBracesCount >= n && closeBracesCount >= n){
            String outputStr = output.toString();
            result.add(outputStr.substring(1, outputStr.length() - 1).replace(",", ""));
        }

        if(openBracesCount < n){
            output.add('{');
            backtrack(n, openBracesCount + 1, closeBracesCount, output, result);
            output.remove(output.size() - 1);
        }

        if(closeBracesCount < openBracesCount) {
            output.add('}');
            backtrack(n, openBracesCount, closeBracesCount + 1, output, result);
            output.remove(output.size() - 1);
        }
    }

    static ArrayList<String> generateCombinations(int n){
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Character> output = new ArrayList<>();
        backtrack(n, 0, 0, output, result);
        return result;
    }
}
