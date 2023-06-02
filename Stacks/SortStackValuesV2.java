package Stacks;

public class SortStackValuesV2 {
    public static void insert(Stack<Integer> stack, int value){
        if(stack.isEmpty() || value < stack.top() ){
            stack.push(value);
        }else{
            int temp = stack.pop();
            insert(stack, value);
            stack.push(temp);
        }
    }

    public static Stack<Integer> sortStack(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int value = stack.pop();
            sortStack(stack);
            insert(stack, value);
        }

        return stack;
    }


}
