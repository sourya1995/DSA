package Algorithms.Strings;

import java.util.HashMap;
import java.util.Map;

public class VerifyAlienDictionary {
    public static boolean verifyAlienDictionary(String[] words, String order){
        if(words.length) == 1 return true;

        Map<Character, Integer> keyMap = new HashMap<>();

        for(int i = 0; i < order.length(); i++){
            keyMap.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                if(j >= words[i+1].length()){
                    return false;
                }

                if(words[i].charAt(j) != words[i+1].charAt(j)){
                    if(keyMap.get(words[i].charAt(j)) > keyMap.get(words[i+1].charAt(j))){
                        return false;
                    } else {
                        break;
                    }
        }
    }
}

return true;
    }
}
