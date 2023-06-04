package Trees;

public class BinarySearchTreeRecursive {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node recursive_insert(Node currentNode, int value){
        if(currentNode == null){
            return new Node(value);
        }

        if(value < currentNode.getData()){
            currentNode.setLeftChild(recursive_insert(currentNode.getLeftChild(), value));
        } else if(value > currentNode.getData()){
            currentNode.setRightChild(recursive_insert(currentNode.getRightChild(), value));
        } else {
            return currentNode;
        }

        return currentNode;
    }

    public Node search(int value){
        if(isEmpty()){
            return null;
        }

        return searchRecursive(root, value);
    }

    public Node searchRecursive(Node currentNode, int value){
        if(currentNode == null || currentNode.getData() == value){
            return currentNode;
        }

        if(currentNode.getData() > value){
            return searchRecursive(currentNode.getLeftChild(), value);
        }

        else {
            return searchRecursive(currentNode.getRightChild(), value);
        }
    }

    public boolean add(int value){
        root = recursive_insert(this.root, value);
        return true;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void printTree(Node current){
        if(current == null){
            return;
        }

        System.out.println(current.getData() + ",");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());
    }

    public static int findMin(Node root){
        if(root == null)
            return -1;
        else if(root.getLeftChild() == null)
            return root.getData();
        else 
            return findMin(root.getLeftChild());
    }

    class checkKthMax{
        static int counter;
        public static int findKthMax(Node root, int k){
            counter = 0;
            Node node = findKthMaxRecursive(root, k);
            if(node!= null) return node.getData();
            return -1;
        }

        public static Node findKthMaxRecursive(Node root, int k){
            if(root == null){
                return null;
            }

            Node node = findKthMaxRecursive(root.getRightChild(), k); //get the right child

            if(counter != k){
                counter++; //increment counter if kth element is not found
                node = root;
            }

            if(counter == k){
                return node;
            } else {
                return findKthMaxRecursive(root.getLeftChild(), k);
            }
        }
    }
    
}
