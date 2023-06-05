package HashTables;

import java.util.HashSet;

import LinkedLists.SinglyLinkedList;

public class HashingUnionIntersection {
    public static<T> SinglyLinkedList<T> unionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2){
        SinglyLinkedList<T> result = new SinglyLinkedList<>();
        HashSet<T> visited = new HashSet<>();
        SinglyLinkedList<T>.Node current = list1.getHeadNode();

        while(current != null){
            if(!visited.contains(current.data)){
                result.insertAtHead(current.data);
                visited.add(current.data);
            }
            current = current.nextNode;
        }

        current = list2.getHeadNode();
        while(current != null){
            if(!visited.contains(current.data)){
                result.insertAtHead(current.data);
                visited.add(current.data);
            }
            current = current.nextNode;
        }
        return result;
    }

    public static<T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2){
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        HashSet<T> visited = new HashSet<T>();
        SinglyLinkedList<T>.Node current = list1.getHeadNode();
        while(current != null){
            if(!visited.contains(current.data)){
                visited.add(current.data);
            }
            current = current.nextNode;
        }

        current = list2.getHeadNode();
        while(current != null){
            if(visited.contains(current.data)){
                result.insertAtHead(current.data);
                visited.remove(current.data);
            }
            current = current.nextNode;
        }
        return result;
    }

}
