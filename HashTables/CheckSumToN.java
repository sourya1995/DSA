package HashTables;

import java.util.HashSet;
import java.util.Set;

public class CheckSumToN {
    public static int[] findSum(int[] arr, int n){
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int i: arr){
            if(set.contains(n - i)){
                result[0] = i;
                result[1] = n - i;
                break; 
            }
            set.add(i);
        }
        return result;
    }
}
