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
        if (isEmpty()) {
            return null;
        }

        Node currentNode = this.root;

        while (currentNode != null) {
            if (currentNode.getData() == value) {
                return currentNode;
            }

            if (currentNode.getData() > value) {
                return currentNode.getLeftChild();
            } else
                return currentNode.getRightChild();
        }

        System.out.println("Not found in the tree");
        return null;
    }

    boolean delete(int value, Node currentNode) {
        if (root == null) {
            return false;
        }

        Node parent = null;
        while (currentNode != null && (currentNode.getData() != value)) {
            parent = currentNode;
            if (currentNode.getData() > value) {
                currentNode = currentNode.getLeftChild();
            } else
                currentNode = currentNode.getRightChild();
        }

        if (currentNode == null) {
            return false;
        }

        else if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            if (root.getData() == currentNode.getData()) {
                setRoot(null);
                return true;
            } else if (currentNode.getData() < parent.getData()) {
                parent.setLeftChild(null);
                return true;
            } else {
                parent.setRightChild(null);
                return true;
            }
        } else if (currentNode.getRightChild() == null) {
            if (root.getData() == currentNode.getData()) {
                setRoot(currentNode.getLeftChild());
                return true;
            } else if (currentNode.getData() < parent.getData()) {
                parent.setLeftChild(currentNode.getLeftChild());
                return true;
            } else {
                parent.setRightChild(currentNode.getLeftChild());
                return true;
            }
        } else if (currentNode.getLeftChild() == null) {
            if (root.getData() == currentNode.getData()) {
                setRoot(currentNode.getRightChild());
                return true;
            } else if (currentNode.getData() < parent.getData()) {
                parent.setLeftChild(currentNode.getRightChild());
                return true;
            } else {
                parent.setRightChild(currentNode.getRightChild());
                return true;
            }

        } else {
            Node leastNode = findLeastNode(currentNode.getRightChild());
            int temp = leastNode.getData();
            delete(temp, root);
            currentNode.setData(temp);
            return true;
        }

    }

    private Node findLeastNode(Node currentNode) {
        Node temp = currentNode;

        while (temp.getLeftChild() != null) {
            temp = temp.getLeftChild();
        }
        return temp;
    }

    public void printTree(Node current) {
        if (current == null)
            return;
        System.out.println(current.getData() + ",");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());
    }

}
