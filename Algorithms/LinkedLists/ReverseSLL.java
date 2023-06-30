import Algorithms.LinkedLists.LinkedListImplementation.LinkedListNode;

public class ReverseSLL {
    public static LinkedListNode reverse(LinkedListNode head) {
        if (head == null || head.next == null)
            return head;

        LinkedListNode listToDo = head.next;
        LinkedListNode reversedList = head;
        reversedList.next = null;

        while (listToDo != null) {
            LinkedListNode temp = listToDo;
            listToDo = listToDo.next;
            temp.next = reversedList;
            reversedList = temp;
        }
        return reversedList;
    }

    public static LinkedListNode reverseRecurse(LinkedListNode head) {
        if (head == null || head.next == null)
            return head;

        LinkedListNode reversed = reverseRecurse(head.next);
        head.next.next = head;

        head.next = null;

        return reversed;
    }
}