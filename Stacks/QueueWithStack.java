package Stacks;

public class QueueWithStack<V> {
    Stack<V> stack1;
    Stack<V> stack2;

    public QueueWithStack(int maxSize) {
        stack1 = new Stack<>(maxSize);
        stack2 = new Stack<>(maxSize);
    }

    public boolean isEmpty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }

    public void enqueue(V v) {
        stack1.push(v);
    }

    public V dequeue() {

        if (isEmpty()) {
            return null;
        } else if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            return stack2.pop();
        } else {
            return stack2.pop();
        }

    }
}
