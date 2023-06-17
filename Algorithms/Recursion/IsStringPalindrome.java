package Algorithms.Recursion;

public class IsStringPalindrome {
    public static boolean isPalindrome(String text){
        if(text.length() <= 1){
            return true;
        }
        else {
            if(text.charAt(0) == text.charAt(text.length() - 1)){
                return isPalindrome(text.substring(1, text.length() - 1));
            }
        }
        return false;
    }
    
}
