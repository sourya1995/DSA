package Algorithms.LinkedLists;

import Algorithms.LinkedLists.LinkedListImplementation.LinkedListNode;

public class ReverseEven {
    public static LinkedListNode mergeAlternating(LinkedListNode list1, LinkedListNode list2) {
        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        LinkedListNode head = list1;
        while(list1.next != null && list2 != null){
            LinkedListNode temp = list2;
            list2 = list2.next;

            temp.next = list1.next;
            list1.next = temp;
            list1 = temp.next;
        }

        if(list1.next == null){
            list1.next = list2;
        }

        return head;
    }
}
