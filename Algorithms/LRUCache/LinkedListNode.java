package Algorithms.LRUCache;

public class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;
    public LinkedListNode<T> previous;

    public LinkedListNode(T dataVal) {
        this.data = dataVal;
        this.next = null;
        this.previous = null;
    }
}
