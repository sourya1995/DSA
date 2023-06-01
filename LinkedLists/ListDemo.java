package LinkedLists;
class ListDemo {
    public static void main(String args[]) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.printList();
        for (int i = 1; i <= 10; i++) {
            sll.insertAtHead(i);
            sll.printList();
        }
    }

    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        if (list.isEmpty()) {
            return null;
        }

        SinglyLinkedList.Node mid = list.headNode;
        SinglyLinkedList.Node current = list.headNode;

        while (mid != null && current != null && current.nextNode != null) {
            current = current.nextNode.nextNode; // jump 2 spots
            if (current != null) {
                mid = mid.nextNode; // mid jumps one spot forward
            }
        }
        return mid.data;
    }

    public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node current = list.headNode;
        SinglyLinkedList<T>.Node compare = null;

        while (current != null && current.nextNode != null) {
            compare = current;
            while (compare.nextNode != null) {
                if (current.data.equals(compare.nextNode.data)) {
                    compare.nextNode = compare.nextNode.nextNode; // shift right pointer by one
                } else {
                    compare = compare.nextNode; // shift by one
                }
            }
            current = current.nextNode;
        }
    }

    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        if (list1.isEmpty()) {
            return list2;
        }
        if (list2.isEmpty()) {
            return list1;
        }

        SinglyLinkedList<T>.Node last = list1.getHeadNode();
        while (last.nextNode != null) {
            last = last.nextNode;
        }
        last.nextNode = list2.getHeadNode();
        list1.removeDuplicatesWithHashing();

        return list1;

    } // get Head of list 2 and attach to end of list 1, then remove duplicates

    public static <T> boolean contains(SinglyLinkedList<T> list, T data) {
        SinglyLinkedList<T>.Node current = list.getHeadNode();
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        if (list1.isEmpty()) {
            return result;
        }
        if (list2.isEmpty()) {
            return result;
        }

        SinglyLinkedList<T>.Node current = list1.getHeadNode();

        while (current != null) {
            if (contains(list2, current.data)) {
                result.insertAtHead(current.data);
            }
            current = current.nextNode;

        }
        return result;
    }

    public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
        int size = list.getSize();
        n = size - n + 1;
        if (size == 0 || n > size) {
            return null;
        }
        SinglyLinkedList.Node current = list.getHeadNode();

        int count = 1;
        while (current != null) {
            if (count == n) {
                return current.data;
            }
            count++;
            current = current.nextNode;
        }
        return null;

    }

    public static <T> boolean isPalindrome(DoublyLinkedListWithTail<T> list) {
        DoublyLinkedListWithTail<T>.Node start = list.getHeadNode();
        DoublyLinkedListWithTail<T>.Node end = list.getHeadNode();
        if (start == null) {
            return true;
        }

        while (start != null) {
            if (start.data != end.data) {
                return false;
            }
            start = start.nextNode;
            end = end.prevNode;

        }
        return true;

    }

}