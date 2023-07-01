package Algorithms.LinkedLists;

import Algorithms.LinkedLists.LinkedListImplementation.LinkedListNode;

public class FoldList {
    public static void reorderList(LinkedListNode head) {
        if (head == null) {
            return;
        }

        // find middle of list
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse 2nd half of list
        LinkedListNode prev = null;
        LinkedListNode curr = slow;
        LinkedListNode temp = null;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // merge two sorted lists
        LinkedListNode first = head;
        LinkedListNode second = prev;
        while (second.next != null) {
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}
