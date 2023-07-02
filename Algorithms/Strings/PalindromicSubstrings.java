package Algorithms.Strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings {
    public static void findPalindromesInSubString(String input, int j, int k, List<String> palindrome){
        for(; j >= 0 && k < input.length(); --j, ++k){
            if(input.charAt(j) != input.charAt(k)){
                break;
            }

            palindrome.add(input.substring(j, k+1));
        }
    }

    public static List<String> findPalindromesInSubStrings(String input){
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < input.length(); ++i){
            findPalindromesInSubString(input, i - 1, i + 1, result);
            findPalindromesInSubString(input, i, i + 1, result);
        }

        return result;
    }
}
