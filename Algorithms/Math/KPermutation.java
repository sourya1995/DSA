package Algorithms.Math;

import java.util.ArrayList;
import java.util.List;

public class KPermutation {
    static void FindKPermutation(List<Character> v, int k, StringBuilder result, List<Integer> factorial) {
        if(v.isEmpty()){
            return;
        }

        int n = v.size();

        int selected = (k - 1) / factorial.get(n - 1);
        result.append(v.get(selected));
        v.remove(selected);
        k = k - (factorial.get(n-1) * selected);
        FindKPermutation(v, k, result, factorial);
    }

    static String getPermutation(int n, int k){
        List<Character> v = new ArrayList<Character>();

        char c = '1';
        for(int i = 1; i <= n; i++){
            v.add(c);
            c++;
        }

        List<Integer> factorial = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(i == 0 || i == 1){
                factorial.add(1);
            } else {
                factorial.add(i * factorial.get(i - 1));
            }
            
    }

    StringBuilder result = new StringBuilder();
    FindKPermutation(v, k, result, factorial);
    return result.toString();
}
