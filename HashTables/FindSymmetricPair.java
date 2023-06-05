package HashTables;

import java.util.HashMap;

public class FindSymmetricPair {
    public static String findSymmetric(int[][] arr){
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        String result = "";
        for(int i=0; i<arr.length; i++){
            int first = arr[i][0];
            int second = arr[i][1];
            Integer value = hashMap.get(second);

            if(value != null && value == first){
                result += "{" + String.valueOf(second) + "," + String.valueOf(first) + "}";
            }
            else{
                hashMap.put(first, second);
            }

        }
        return result;
    }
    
}
