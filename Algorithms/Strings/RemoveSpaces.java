package Algorithms.Strings;

import java.util.Arrays;

public class RemoveSpaces {
    static boolean isWhiteChar(char c) {
        if(c == ' ' || c == '\t'){
            return true;
        }
        return false;
    }

    static String removeWhiteSpaces(char[] s){
        if(s == null || s.length == 0 || s[0] == '\0') {
            return " ";
        }

        int readPtr = 0;
        int writePtr = 0;

        while(readPtr < s.length && s[readPtr] != '\0'){
            if(!isWhiteChar(s[readPtr])){
                s[writePtr] = s[readPtr];
                writePtr++;
            }
           readPtr++; 
        }
        String ansStr = String.valueOf(Arrays.copyOfRange(s, 0, writePtr));
        return ansStr;
    }

    }

