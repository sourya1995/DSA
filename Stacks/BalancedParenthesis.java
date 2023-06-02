package Stacks;

public class BalancedParenthesis {
    public static boolean isBalanced(String exp){
        Stack<Character> stack = new Stack<>(exp.length());
        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);
            if(c == '}' || c == ')' || c == ']'){
                if(stack.isEmpty()) return false;
                if((c == '}' && stack.pop() != '{') || (c == ')' && stack.pop() != '(') || (c == ']' && stack.pop() != '[')) return false;
            }
            else stack.push(c);
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
    
}
