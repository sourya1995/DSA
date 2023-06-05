package HashTables;

import java.util.HashMap;
import java.util.Map;

public class TracingPathProblem {
    public static String tracePath(Map<String, String> map){
        String result = "";
        HashMap<String, String> reverseMap = new HashMap<>();
        for(Map.Entry<String, String> entry: map.entrySet()){
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        String from = "";
        int count = 0;
        for(Map.Entry<String, String> entry: map.entrySet()){
            if(!reverseMap.containsKey(entry.getKey())){
                count++;
                from = entry.getKey();
            }
        }

        if(count > 1){
            return "null";
        }

        String to = map.get(from);
        while(to != null){
            result += from + "->" + to + ",";
            from = to;
            to = map.get(to);
        }

        return result;


    }/* the logic is, if we reverse the map, the keys become values (departures). Now there is
    a key in the map, which does not appear as a key in the reverse map. THIS is the starting point */
    
}
