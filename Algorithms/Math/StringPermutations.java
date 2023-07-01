package Algorithms.Math;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    static void swapChar(char[] input, int i, int j){
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    static void permuteStringRec(char[] input, int currentIndex, List<String> result){
        if(input.length == 0){
            String addInput = "";
            result.add(input);
            return;
        }

        if(currentIndex == input.length - 1){
            String addInput = new String(input);
            result.add(addInput);
            return;
        }

        for(int i = currentIndex; i < input.length; i++){
            swapChar(input, currentIndex, i);
            permuteStringRec(input, currentIndex + 1, null);
            swapChar(input, currentIndex, i);
        }
    }

    static List<String> permuteString(String input) {
        List<String> result = new ArrayList<String>();
        permuteStringRec(input.toCharArray(), 0, result);
        return result;
    }
}
