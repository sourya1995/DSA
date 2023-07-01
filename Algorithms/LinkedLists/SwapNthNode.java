package Algorithms.LinkedLists;

import Algorithms.LinkedLists.LinkedListImplementation.LinkedListNode;

public class SwapNthNode {
    static LinkedListNode swapNthNode(LinkedListNode head, int n){
        LinkedListNode prev = null;
        LinkedListNode current = head;

        if(head == null || n == 1){
            return head;
        }

        for(int count = 1; current != null && count < n; count++){
            prev = current;
            current = current.next;
        }

        if(current == null) return head;

        prev.next = head;
        LinkedListNode temp = head.next;
        head.next = current.next;
        current.next = temp;

        return current;
    }
}
