class ListDemo {
    public static void main( String args[] ) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.printList();
        for (int i = 1; i <= 10; i++) {
			sll.insertAtHead(i);
			sll.printList();
        }
    }

    public static <T> Object findMiddle(SinglyLinkedList<T> list){
        if(list.isEmpty()){
            return null;
        }

        SinglyLinkedList.Node mid = list.headNode;
        SinglyLinkedList.Node current = list.headNode;

        while(mid != null && current != null && current.nextNode != null){
            current = current.nextNode.nextNode; //jump 2 spots
            if(current != null){
                mid = mid.nextNode; //mid jumps one spot forward
            }
        }
        return mid.data;
    }

    public static <T> void removeDuplicates(SinglyLinkedList<T> list){
        SinglyLinkedList<T>.Node current = list.headNode;
        SinglyLinkedList<T>.Node compare = null;

        while(current != null && current.nextNode != null) {
            compare = current;
            while(compare.nextNode != null){
                if(current.data.equals(compare.nextNode.data)){
                    compare.nextNode = compare.nextNode.nextNode; //shift right pointer by one
                } else {
                    compare = compare.nextNode; //shift by one
                }
            }
            current = current.nextNode;
        }
    }


}