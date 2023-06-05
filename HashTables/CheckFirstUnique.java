package HashTables;

import java.util.HashMap;
import java.util.Map;

public class CheckFirstUnique {
    public static int findFirstUnique(int[] arr){
        Map<Integer, Integer> countElements = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(countElements.containsKey(arr[i])){
                int occurrence = countElements.get(arr[i]) + 1;
                countElements.put(arr[i], occurrence);
            }
            else{
                countElements.put(arr[i], 0);
            }
        }

        for(int i=0; i < arr.length; i++){
            if(countElements.get(arr[i]) == 0){
                return arr[i];
            } 
        }
        return -1;
        
    }
}
