package Algorithms.LRUCache;

public class LinkedList {
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int length;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int size() {
        return this.length;
    }

    public void insertAtHead(T data) {
        LinkedListNode<T> newNode = new LinkedListNode<T>(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
        }
        this.length++;
    }

    public void insertAtTail(T data) {
        LinkedListNode<T> newNode = new LinkedListNode<T>(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.previous = this.tail;
            this.tail = newNode;
        }
        this.length++;
    }

    public void addFirst(LinkedListNode<T> newNode) {
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
        }
        this.length++;
    }

    public void addLast(LinkedListNode<T> newNode) {
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.previous = this.tail;
            this.tail = newNode;
        }
        this.length++;
    }

    public void remove(T data) {
        LinkedListNode<T> temp = this.head;
        while (temp != null) {
            if (temp.data == data) {
                this.remove(temp);
                return;
            }
            temp = temp.next;
        }
    }

    public void remove(LinkedListNode<T> node) {
        if (node == null)
            return;
        if (node.previous != null)
            node.previous.next = node.next;

        if (node.next != null)
            node.next.previous = node.previous;

        if (node == this.head)
            this.head = this.head.next;

        if (node == this.tail) {
            this.tail = this.tail.previous;
            if (this.tail != null)
                this.tail.next = null;
        }
        this.length--;
        node = null;
    }

    public void removeFirst() {
        this.remove(this.head);
    }

    public void removeLast() {
        this.remove(this.tail);
    }

    public LinkedListNode<T> getFirst() {
        return this.head;
    }

    public LinkedListNode<T> getLast() {
        return this.tail;
    }
}
