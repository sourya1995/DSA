package Algorithms.Recursion;

public class LLSearch {
    public static boolean search(Node head, int num){
        if(head == null){
            return false;
        }

        else {
            if(head.value == null){
                return true;
            }
            else {
                return search(head.next, num);
            }
        }
    }
}
