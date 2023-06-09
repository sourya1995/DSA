package Algorithms.Graphs;

public class Queue<V> {
    private int maxSize;
    private V[] array;
    private int front;
    private int back;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public Queue(int maxSize){
        this.maxSize = maxSize;
        array = (V[]) new Object[maxSize];
        front = 0;
        back = -1;
        currentSize = 0;
    }

    public int getMaxSize(){
        return maxSize;
    }

    public int getCurrentSize(){
        return currentSize;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean isFull(){
        return currentSize == maxSize;
    }

    public V top(){
        return array[front];
    }

    public void enqueue(V v){
        if(isFull()){
            return;
        }

        back = (back + 1) % maxSize;
        array[back] = v;
        currentSize++;
    }

    public V dequeue(){
        if(isEmpty()){
            return null;
        }

        V temp = array[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return temp;
    }
    
}
