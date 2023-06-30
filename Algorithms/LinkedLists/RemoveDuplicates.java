package Algorithms.LinkedLists;

import java.util.HashSet;

import Algorithms.LinkedLists.LinkedListImplementation.LinkedListNode;

public class RemoveDuplicates {
    public static LinkedListNode removeDuplicates(LinkedListNode head){
        if(head == null) return head;

        HashSet<Integer> duplicates = new HashSet<>();
        duplicates.add(head.data);
        LinkedListNode current = head;

        while(current.next != null){
            if(duplicates.contains(current.next.data)){
                current.next = current.next.next; //skip this guy
            } else {
                duplicates.add(current.next.data);
                current = current.next;
            }
        }
        return head;
    }
}
