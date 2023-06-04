package Trees;

public class BinarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean add(int value) {

        if (isEmpty()) {
            root = new Node(value);
            return true;
        }

        Node currentNode = root;

        while (currentNode != null) {
            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();

            if (currentNode.getData() > value) {
                if (leftChild == null) {
                    leftChild = new Node(value);
                    currentNode.setLeftChild(leftChild);
                    return true;
                }
            }

            else {
                if (rightChild == null) {
                    rightChild = new Node(value);
                    currentNode.setRightChild(rightChild);
                    return true;
                }
                currentNode = rightChild;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node search(int value) {
        if(isEmpty()){
            return null;
        }

        Node currentNode = this.root;

        while(currentNode != null){
            if(currentNode.getData() == value){
                return currentNode;
            }

            if(currentNode.getData() > value){
                return currentNode.getLeftChild();
            }
            else
             return currentNode.getRightChild();
        }

        System.out.println("Not found in the tree");
        return null;
    }

    public void printTree(Node current) {
        if (current == null)
            return;
        System.out.println(current.getData() + ",");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());
    }

}
