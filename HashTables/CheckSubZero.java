package HashTables;

import java.util.HashMap;

public class CheckSubZero {
    public static boolean findSubZero(int[] arr){
        HashMap <Integer, Integer> hMap = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(arr[i] == 0 || sum == 0 || hMap.get(sum) != null ) return true;
            hMap.put(sum, i);
        }
        return false;
    }
}
