package Stacks;

public class QueueWithStack <V>{
    Stack<V> stack1;
    Stack<V> stack2;
    
    public QueueWithStack(int maxSize){
        stack1 = new Stack<>(maxSize);
        stack2 = new Stack<>(maxSize);
    }

    public boolean isEmpty(){
        return stack1.isEmpty();
    }

    public void enqueue(V v){
        stack1.push(v);
    }

    public V dequeue(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        V result = stack2.pop();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return result;
    }
}
