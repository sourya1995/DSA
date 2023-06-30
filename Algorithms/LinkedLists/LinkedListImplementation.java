package Algorithms.LinkedLists;

import java.util.List;

public class LinkedListImplementation {
    class LinkedListNode {
        public int data;
        public LinkedListNode next;
        public LinkedListNode previous;
        public LinkedListNode arbitraryPointer;

        public LinkedListNode(int data){
            this.data = data;
            this.next = null;
            this.previous = null;
            this. arbitraryPointer = null;
        }
    }

    class LinkedList{
        public LinkedListNode head;
        public LinkedList(){
            this.head = null;
        }

        public void insertAtHead(int data){
            if(this.head == null){
                this.head = new LinkedListNode(data);
            } else {
                LinkedListNode newNode = new LinkedListNode(data);
                newNode.next = this.head;
                this.head = newNode;
            }
        }

        public void insertAtTail(int data){
            if(this.head == null){
                this.head = new LinkedListNode(data);
            } else {
                LinkedListNode newNode = new LinkedListNode(data);
                LinkedListNode temp = this.head;
                while(temp.next != null){
                    temp = temp.next;

                }
                temp.next = newNode;
            }
        }

        public void createLinkedList(List<Integer> lst){
            for(int i = lst.size() - 1; i >= 0; i--){
                insertAtHead(lst.get(i));
            }
        }

        public void displayLinkedList(){
            LinkedListNode temp = this.head;
            StringBuilder result = new StringBuilder("[");
            while(temp != null){
                result.insert(result.length(), temp.data);
                temp = temp.next;
                if(temp != null){
                    result.insert(result.length(), ",");
                }
            }
            result.insert(result.length(), "]");
            System.out.println(result.toString());
        }
    }
}
