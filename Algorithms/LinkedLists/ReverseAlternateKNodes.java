import Algorithms.LinkedLists.LinkedListImplementation.LinkedListNode;

public class ReverseAlternateKNodes{
    static LinkedListNode reverseKNodes(LinkedListNode head, int k){
        if(k <=1 || head == null){
            return head;
        }

        LinkedListNode reversed = null;
        LinkedListNode prevTail = null;

        while(head != null && k > 0){
            LinkedListNode currentHead = null;
            LinkedListNode currentTail = head;
            int n = k;

            while(head != null && n > 0){
                LinkedListNode temp = head.next;
                head.next = currentHead;
                currentHead = head;
                head = temp;
                n--;
            }

            if(reversed == null){
                reversed = currentHead;
            }

            if(prevTail != null){
                prevTail.next = currentHead;
            }
            prevTail = currentTail;
        }
        return reversed;
    }
}