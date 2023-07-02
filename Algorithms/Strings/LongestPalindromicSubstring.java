package Algorithms.Strings;

public class LongestPalindromicSubstring {
    public static String longestPalindromicSubstring(String s){
        if(s == null || s.isEmpty()) return " ";

        int start = 0, end = 0;

        for(int i = 0; i < s.length(); i++){
            int len1 = returnPalindromeLength(s, i, i);
            int len2 = returnPalindromeLength(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start){
                start = i - (len - 1) / 2;
                end = i + len/2;
            }
        }

        return s.substring(start, end + 1);

    }

    private static int returnPalindromeLength(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
