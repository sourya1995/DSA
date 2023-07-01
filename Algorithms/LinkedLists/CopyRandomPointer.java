package Algorithms.LinkedLists;

public class CopyRandomPointer {
    public Node deepCopyArbitraryPointer(Node head) {
    if (head == null) {
        return null;
    }

    // Step 1: Create a copy of each node and insert it next to the original node
    Node current = head;
    while (current != null) {
        Node newNode = new Node(current.val);
        newNode.next = current.next;
        current.next = newNode;
        current = newNode.next;
    }

    // Step 2: Update the arbitrary pointers of the copied nodes
    current = head;
    while (current != null) {
        if (current.random != null) {
            current.next.random = current.random.next;
        }
        current = current.next.next;
    }

    // Step 3: Separate the original and copied nodes into two separate lists
    Node newHead = head.next;
    Node currentOriginal = head;
    Node currentCopy = newHead;

    while (currentOriginal != null) {
        currentOriginal.next = currentOriginal.next.next;
        if (currentCopy.next != null) {
            currentCopy.next = currentCopy.next.next;
        }
        currentOriginal = currentOriginal.next;
        currentCopy = currentCopy.next;
    }

    return newHead;
}

}
