package Stacks;

public class MinimumStack {
    int maxSize;
    Stack<Integer> mainStack;
    Stack<Integer> minStack; //top always contains the current minimum of the stack

    public MinimumStack(int maxSize) {
        this.maxSize = maxSize;
        mainStack = new Stack<>(maxSize);
        minStack = new Stack<>(maxSize);
    }

    public int pop() {
        minStack.pop();
        return mainStack.pop();
    }

    public void push(Integer value){
        mainStack.push(value);
        if(!minStack.isEmpty() && minStack.top() < value)
            minStack.push(minStack.top());
        else
            minStack.push(value);
    }

    public int min(){
        return minStack.top();
    }
}
