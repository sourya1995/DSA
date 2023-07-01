package Algorithms.LinkedLists;

import Algorithms.LinkedLists.LinkedListImplementation.LinkedListNode;

public class MergeSortedLists {
    public static LinkedListNode mergeSorted(LinkedListNode head1, LinkedListNode head2){
        if(head1 == null){
            return head2;
        } else if(head2 == null){
            return head1;
        }

        LinkedListNode mergeHead = null;
        if(head1.data <= head2.data){
            mergeHead = head1;
            head1 = head1.next;
        } else {
            mergeHead = head2;
            head2 = head2.next;
        }



        LinkedListNode mergeTail = mergeHead;

        while(head1 != null && head2 != null){
            LinkedListNode temp = null;
            if(head1.data <= head2.data){
                temp = head1;
                head1 = head1.next;
            } else {
                temp = head2;
                head2 = head2.next;
            }

            mergeTail.next = temp;
            mergeTail = temp;
        }

        if(head1 != null){
            mergeTail.next = head1;
        } else if(head2 != null) {
            mergeTail.next = head2;
        }

        return mergeHead;
    }
}
