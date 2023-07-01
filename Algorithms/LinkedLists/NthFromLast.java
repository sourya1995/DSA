package Algorithms.LinkedLists;

import Algorithms.LinkedLists.LinkedListImplementation.LinkedListNode;

public class NthFromLast {
    public static LinkedListNode findNthFromLast(LinkedListNode head, int n){
        if(head == null || n < 1){
            return null;
        }

        LinkedListNode tail = head;

        while(tail != null && n > 0) {
            tail = tail.next;
            --n;
        }

        if( n != 0){
            return null;
        }

        while(tail != null){
            tail = tail.next;
            head = head.next;
        }

        return head;
    }
}
