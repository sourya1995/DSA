package Algorithms.LinkedLists;

import Algorithms.LinkedLists.LinkedListImplementation.LinkedListNode;

public class RotateList {
    private static int findLength(LinkedListNode head){
        int len = 0;

        while(head != null) {
            ++len;
            head = head.next;
        }

        return len;
    }

    private static int adjustRotationsNeeded(int n, int len){
        n = n % len;
        if(n < 0){
            n = n + len;
        }

        return n;
    }

    public static LinkedListNode rotateList(LinkedListNode head, int n){
        if(head == null || n == 0) return head;

        int len = findLength(head);

        n = adjustRotationsNeeded(n, len);
        if(n ==0){
            return head;
        }

        int rotationsCount = len - n - 1;
        LinkedListNode temp = head;

        while (rotationsCount > 0){
            rotationsCount--;
            temp = temp.next;
        }

        LinkedListNode newHead = temp.next;
        temp.next = null;
        temp = newHead;

        while(temp.next != null){
            temp = temp.next;

        }
        temp.next = head;

        return newHead;
    }
}
