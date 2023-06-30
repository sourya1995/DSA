import Algorithms.LinkedLists.LinkedListImplementation.LinkedListNode;

public class InsertionSort {
    public static LinkedListNode sortedInsert(LinkedListNode head, LinkedListNode node){
        if(node == null) return head;

        if(head == null || node.data <= head.data) {
            node.next = head;
            return node;
        }

        LinkedListNode current = head;
        while(current.next != null && (current.next.data < node.data)){
            current = current.next;
        }

        node.next = current.next;
        current.next = node;

        return head;
    }

    public static LinkedListNode insertionSort(LinkedListNode head){
        LinkedListNode sorted = null;
        LinkedListNode current = head;

        while(current != null){
            LinkedListNode temp = current.next;
            sorted = sortedInsert(sorted, current);
            current = temp;
        }
        return sorted;
    }
}