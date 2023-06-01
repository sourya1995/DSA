public class DoublyLinkedList<T> {
    public class Node {
        public T data;
        public Node nextNode;
        public Node prevNode;
    }

    public Node headNode;
    public int size;

    public Node getHeadNode() { return headNode; }
    public int getSize() { return size; }

    public DoublyLinkedList(){
        this.headNode = null;
    }

    public boolean isEmpty() {
        if (headNode == null){
            return true;

        }
        return false;
    }

    public void insertAtHead(T data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = this.headNode;
        newNode.prevNode = null;
        if(headNode != null){
            headNode.prevNode = newNode;
        }
        this.headNode = newNode;
        size++;
    }

    public void removeAtHead(){
        if (isEmpty()) {
            return;
        }

        headNode = headNode.nextNode;
        headNode.prevNode = null;
        size--;
    }

    public void deleteByValue(T data){
        if(isEmpty()){
            return;
        }

        Node currentNode = this.headNode;
        if(currentNode.data.equals(data)){
            removeAtHead();
            return;
        }

        while(currentNode != null){
            if(data.equals(currentNode.data)){
                currentNode.prevNode.nextNode = currentNode.nextNode;
                if(currentNode.nextNode != null){
                    currentNode.nextNode.prevNode = currentNode.prevNode;
            }
            size--;
        }
        currentNode = currentNode.nextNode;
    }
}

    public void printList() {
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }

        Node temp = headNode;
        System.out.println("List:");
        while(temp.nextNode != null){
            System.out.println(temp.data.toString() +  "<->");
            temp = temp.nextNode;
        }
        System.out.print(temp.data.toString() + "-> null");
    }

}
