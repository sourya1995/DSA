package Algorithms.Graphs;

public class Stack<V> {
    private int maxSize;
    private int top;
    private V array[];
    private int currentSize;

    @SuppressWarnings("unchecked")
    public Stack(int max_size){
        this.maxSize = max_size;
        this.top = -1;
        array = (V[]) new Object[max_size];
        this.currentSize = 0;
    }

    public int getCurrentSize(){
        return currentSize;
    }

    public int getMaxSize(){
        return maxSize;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public V top(){
        if(isEmpty())
        return null;

        return array[top];
    }

    public void push(V v){
        if(isFull()){
            System.out.println("stack is full");
            return;
        }

        array[++top] = v;
        currentSize++;
    }

    public V pop(V v){
        if (isEmpty()){
            System.out.println("stack is empty");
            return null;
        }
        currentSize--;
        return array[top--];
    }

}
