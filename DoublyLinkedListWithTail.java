public class DoublyLinkedListWithTail<T> {
    public class Node {
        public T data;
        public Node nextNode;
        public Node prevNode;
    }

    public Node headNode;
    public Node tailNode;
    public int size;

    public DoublyLinkedListWithTail(){
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        if(headNode == null && tailNode == null){
            return true;
        }
        return false;
    }

    public Node getHeadNode() {
        return headNode;
    }
    public Node getTailNode() {
        return tailNode;
    }
    public int getSize() {
        return size;
    }

    public void printList(){
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }

        Node temp = headNode;
        System.out.println("List: null <- ");

        while(temp.nextNode != null){
            System.out.println(temp.data.toString() +"<->");
            temp = temp.nextNode;
        }

        System.out.println(temp.data.toString() + " -> Null");
    }

    public void insertAtHead(T data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = this.headNode;
        newNode.prevNode = null;
        if(headNode != null){
            headNode.prevNode = newNode;
        }
        else {
            tailNode = newNode;
        }
        this.headNode = newNode;
        size++;
    }

    public void insertAtEnd(T data){
        if(isEmpty()){
            insertAtHead(data);
            return;
        }

        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;
        newNode.prevNode = tailNode;
        tailNode.nextNode = newNode;
        tailNode = newNode;
        size++;
    }

    public void deleteAtHead(){
        if(isEmpty()){
            return;
        }

        headNode = headNode.nextNode;
        if(headNode == null){
            tailNode = null;
        }
        else{
            headNode.prevNode = null;
        }
        size--;
    }

    public void deleteAtTail(){
        if(isEmpty()){
            return;
        }
        tailNode = tailNode.prevNode;
        if(tailNode == null){
            headNode = null;
        }
        else{
            tailNode.nextNode = null;
        }
        size--;
    }

}