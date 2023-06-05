package HashTables;

import java.util.HashMap;

public class CheckPair {
    public static String findPair(int[] arr){
        String result = " ";
        HashMap<Integer, int[]> hMap = new HashMap<>(); //sum, array of pairs
        for(int i = 0; i < arr.length; ++i){
            for(int j = i+1; j < arr.length; ++j){
                int sum = arr[i] + arr[j];
                if(!hMap.containsKey(sum)){
                    hMap.put(sum, new int[]{arr[i], arr[j]});
                }
                else{
                    int[] prev_pair = hMap.get(sum);
                    result += "{" + prev_pair[0] + "," + prev_pair[1] + "}{" + arr[i] + "," +arr[j] + "}";
                    return result;
                }
            }
        }
        return result;
    }
}
