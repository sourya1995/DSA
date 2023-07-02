package Algorithms.Strings;

public class LongestValidParentheses {
    public static int LongestValidParentheses(String s) {
        int left = 0, right = 0, maxLength = 0;

        //left pass iteration
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
            }

            else {
                right++;
            }

            if(left == right) {
                maxLength = Math.max(maxLength, 2*right);
            }

            else if(right >= left) {
                left = right = 0;
            }

        }
        left = right = 0;

        //right pass iteration
        for(int i = s.length() - 1; i >= 0; i--) {
              if(s.charAt(i) == '(') {
                left++;
            }

            else {
                right++;
            }

            if(left == right) {
                maxLength = Math.max(maxLength, 2*left);
            }

            else if(left >= right) {
                left = right = 0;
            }
        }

        return maxLength;

    }
}
