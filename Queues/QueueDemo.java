package Queues;
import Stacks.Stack;

public class QueueDemo {

    public static String[] findBin(int number){
        String[] result = new String[number];
        Queue<String> queue = new Queue<String>(number + 1);

        queue.enqueue("1");

        for(int i = 0; i < number; i++){
            result[i] = queue.dequeue();
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            queue.enqueue(s1);
            queue.enqueue(s2);
        }
        return result;
    }

    public static<V> void reverseK(Queue<V> queue, int k){
        if(queue.isEmpty() || k <=0){
            return;
        }
        Stack<V> stack = new Stack<>(k);
        while(!stack.isFull()){
            stack.push(queue.dequeue());
        }

        while(!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }

        int size = queue.getCurrentSize();
        for(int i = 0; i < size - k; i++){
            queue.enqueue(queue.dequeue());
        }


    }
    public static void main(String[] args){

    }
}
