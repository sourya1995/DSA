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


}