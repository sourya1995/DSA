package Algorithms.Strings;

import java.util.HashMap;

public class RomanToInt {
    	public static HashMap<Character, Integer> values = new HashMap<Character, Integer>() {
		{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);
		}
	};

    public static int romanToInt(String s){
        Integer total = 0;
        int i = 0;

        while(i < s.length()){
            if( i + 1 < s.length() && values.get(s.charAt(i)) < values.get(s.charAt(i + 1))){
                total += values.get(s.charAt(i + 1)) - values.get(s.charAt(i));
                i += 2;
            }

            else {
                total += values.get(s.charAt(i));
                i += 1;
            }
        }
        return total;
    }


}
