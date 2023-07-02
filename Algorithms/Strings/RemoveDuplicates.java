package Algorithms.Strings;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    static String removeDuplicates(char[] str){
        if(str == null || str.length == 0 || str[0] =='\0'){
            return "";
        }

        Set<Character> hashset = new LinkedHashSet<Character>();

        int writeIndex = 0;
        int readIndex = 0;

        while(readIndex != str.length){
            if(!hashset.contains(str[readIndex])) {
                hashset.add(str[readIndex]);
                str[writeIndex] = str[readIndex];
                writeIndex++;
            }
            readIndex++;
        }

        String ansStr = String.valueOf(Arrays.copyOfRange(str, 0, writeIndex));
        return ansStr;
    }
}
