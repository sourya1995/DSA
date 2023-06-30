package Algorithms.Arrays;

import java.util.Arrays;
import java.util.Comparator;
 

public class LargestNumber {
   private static class LargeNumberComparator implements Comparator<String>{
        public int compare(String a , String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public static String largestNumber(int[] nums){
        String[] numStr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStr, new LargeNumberComparator());

        if(numStr[0].equals("0")){
            return "0";
        }

        String largestNumberString = new String();
        for(String numAsStr: numStr){
            largestNumberString += numAsStr;
        }

        return largestNumberString;
    }
}
