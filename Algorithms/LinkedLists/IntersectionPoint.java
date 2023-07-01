package Algorithms.LinkedLists;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import Algorithms.LinkedLists.LinkedListImplementation.LinkedListNode;

public class IntersectionPoint {
    public static LinkedListNode intersect(LinkedListNode head1, LinkedListNode head2){
        LinkedListNode list1node = null;
        LinkedListNode list2node = null;

        int list1length = getLength(head1);
        int list2length = getLength(head2);

        int lengthDifference = 0;

        if(list1length >= list2length){
            lengthDifference = list1length - list2length;
            list1node = head1;
            list2node = head2;
        } else {
            lengthDifference = list2length - list1length;
            list1node = head2;
            list2node = head1;

        }

        while(lengthDifference > 0){
            list1node = list1node.next;
            lengthDifference--;
        }

        while(list1node != null && list2node != null){
            if(list1node == list2node){
                return list1node;
            }
            list1node = list1node.next;
            list2node = list2node.next;
        }
        return null;
    }

    private static int getLength(LinkedListNode head){
        int listLength = 0;
        LinkedListNode temp = head;
        while(temp != null){
            temp = temp.next;
            listLength++;
        }
        return listLength;
    }

    static LinkedListNode intersectHash(LinkedListNode head1, LinkedListNode head2){
        Set<LinkedListNode> nodesInList2 = new LinkedHashSet<LinkedListNode>();
        while(head2 != null){
            nodesInList2.add(head2);
            head2 = head2.next;
        }

        while(head1 != null){
            if(nodesInList2.contains(head1)){
                return head1;
            }
            head1 = head1.next;
        }
        return null;
    }
}


