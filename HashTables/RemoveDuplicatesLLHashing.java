package HashTables;

import java.util.HashSet;

import LinkedLists.SinglyLinkedList;

public class RemoveDuplicatesLLHashing {
    public static<V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list){
        SinglyLinkedList<V>.Node current = list.getHeadNode();
        SinglyLinkedList<V>.Node prevNode = list.getHeadNode();

        HashSet<V> visitedNodes = new HashSet<V>();
        if(!list.isEmpty() && current.nextNode != null){
            while(current != null){
                if(visitedNodes.contains(current.data)){
                    prevNode.nextNode = current.nextNode; //skip this MF
                    current = current.nextNode;
                } else {
                    visitedNodes.add(current.data);
                    prevNode = current;
                    current = current.nextNode; //moving on
                }
            }
        }
    }
}
