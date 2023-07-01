import Algorithms.LinkedLists.LinkedListImplementation.LinkedListNode;

class Pair<X, Y> {
    public X first;
    public Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }
}


public class MergeSort{
    public static void SplitInHalf(LinkedListNode head, Pair<LinkedListNode, LinkedListNode> linkedList){
        if(head == null){
            return;
        }

        if(head.next == null){
            linkedList.first = head;
            linkedList.second = null;
        } else {
            LinkedListNode slow, fast;
            slow = head;
            fast = head.next;
            while(fast != null){
                fast = fast.next;
                if(fast != null){
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            linkedList.first = head;
            linkedList.second = slow.next;
            slow.next = null;
        }
    }

    public static LinkedListNode mergeSortedLists(LinkedListNode first, LinkedListNode second){
        if(first == null){
            return second;
        } else if(second == null){
            return first;
        }

        LinkedListNode newHead;
        if(first.data <= second.data){
            newHead = first;
            first = first.next;
        } else {
            newHead = second;
            second = second.next;
        }

        LinkedListNode newCurrent = newHead;
        while(first != null && second != null){
            LinkedListNode temp = null;
            if(first.data <= second.data){
                temp = first;
                first = first.next;
            } else {
                temp = second;
                second = second.next;
            }
            newCurrent.next = temp;
            newCurrent = temp;
        }

        if(first != null){
            newCurrent.next = first;
        } else if(second != null){
            newCurrent.next = second;
        }

        return newHead;
    }

    public static LinkedListNode mergeSort(LinkedListNode head){
        if(head == null || head.next == null) {
            return head;
        } 

        Pair<LinkedListNode, LinkedListNode> linkedList = new Pair<LinkedListNode, LinkedListNode>(null, null);
        SplitInHalf(head, linkedList);
        linkedList.first = mergeSort(linkedList.first);
        linkedList.second = mergeSort(linkedList.second);

        return mergeSortedLists(linkedList.first, linkedList.second);
    }
}