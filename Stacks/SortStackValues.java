package Stacks;
import Stacks.Stack;

public class SortStackValues {

    public static void sortStack(Stack<Integer> stack){
        Stack<Integer> newStack = new Stack<>(stack.getMaxSize());
        while(!stack.isEmpty()){
            Integer value = stack.pop(); //get latest value from main stack
            if(!newStack.isEmpty() && value >= newStack.top()){
                newStack.push(value);
            }
            else{
                while(!newStack.isEmpty() && newStack.top() > value){
                    stack.push(newStack.pop());
                }
                newStack.push(value);
            }
        }
        while(!stack.isEmpty()){
            stack.push(newStack.pop());
        }
    }
    
}
