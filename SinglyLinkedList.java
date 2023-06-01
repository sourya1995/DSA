public class SinglyLinkedList<T> {
	public class Node {
		public T data;
		public Node nextNode;
	}

	public Node headNode; //used to track the rest of the LL
	public int size; //size of the list

	public SinglyLinkedList() {
		headNode = null;
		size = 0;
	}

    public boolean isEmpty() { //if head is empty, headNode is null and list is empty
        if (headNode == null) {
            return true;
        }
        return false;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node(); //create a new node
        newNode.data = data; //assign the data to the new node
        newNode.nextNode = headNode; //point to the previous head node
        headNode = newNode; //assign the head to the new node
        size++; //increment the size of the list
    }

    public void printList() {
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }

        Node temp = headNode;
        System.out.println("List: ");
        while(temp.nextNode != null){
            System.out.print(temp.data.toString() + "->");
            temp = temp.nextNode;
        }
        System.out.print(temp.data.toString() + "-> null");
    }
}