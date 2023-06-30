package Algorithms.LinkedLists;

import Algorithms.LinkedLists.LinkedListImplementation.LinkedListNode;

public class DeleteNode {
    public static LinkedListNode deleteNode(LinkedListNode head, int key) {
        LinkedListNode prev = null;
        LinkedListNode current = head;

        while (current != null) {
            if (current.data == key) {
                if (current == head) {
                    head = head.next;
                    current = head;
                } else {
                    prev.next = current.next;
                    current = current.next;
                }
            } else {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }
}
