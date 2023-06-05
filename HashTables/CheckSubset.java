package HashTables;

import java.util.HashSet;

public class CheckSubset {
    static boolean isSubset(int[] arr1, int[] arr2){
        HashSet<Integer> hset = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            if(!hset.contains(arr1[i])){
                hset.add(arr1[i]);
            }
        }

        for(int i=0; i<arr2.length; i++){
            if(!hset.contains(arr2[i])){
                return false;
            }
           
        }
        return true;
    }
}
