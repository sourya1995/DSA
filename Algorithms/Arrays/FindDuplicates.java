package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindDuplicates {
    public static ArrayList<Integer> findDuplicates(int[] arr){
        int arrSize = arr.length;
        ArrayList<Integer> duplicates = new ArrayList<Integer>();
        for(int i = 0; i < arrSize; i++){
            for(int j = i+1; j < arrSize; j++){
                if(arr[i] == arr[j] && i!= j){ //or !duplicates.contains(arr[i]))
                    duplicates.add(arr[i]);
                }
            }
            
        }
        return duplicates;  
    }
    public static ArrayList<Integer> findDuplicatesHashing(int[] arr){
        int arrSize = arr.length;
        ArrayList<Integer> duplicates = new ArrayList<Integer>(arrSize);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        boolean duplicate = false;
        for(int i = 0; i < arrSize; i++){
            if(map.containsKey(arr[i])){
                count = map.get(arr[i]);
                map.put(arr[i], count + 1);
            } else {
                map.put(arr[i], 1);
            }
            }

            int index = 0;
            for(Entry<Integer, Integer> entry: map.entrySet()){
                if(entry.getValue() > 1){
                    duplicates.add(entry.getKey());
                    duplicate = true;
                }
            
        }
        return duplicates;  
    }


}
