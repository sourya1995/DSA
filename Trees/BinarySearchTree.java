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

        else if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) { // LEAF NODE
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
        } else if (currentNode.getRightChild() == null) { // NO RIGHT CHILD
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
        } else if (currentNode.getLeftChild() == null) { // NO LEFT CHILD
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

    public static void preTraverse(Node root) {
        if (root == null)
            return;
        System.out.println(root.getData() + ",");
        preTraverse(root.getLeftChild());
        preTraverse(root.getRightChild());
    }

    public static void inOrderTraverse(Node root) {
        if (root == null)
            return;
        inOrderTraverse(root.getLeftChild());
        System.out.println(root.getData() + ",");
        inOrderTraverse(root.getRightChild());
    }

    public static void postOrderTraverse(Node root) {
        if (root == null)
            return;

        postOrderTraverse(root.getLeftChild());
        postOrderTraverse(root.getRightChild());
        System.out.println(root.getData() + ",");
    }

    public static int findMin(Node root) {
        if (root == null)
            return -1;
        while (root.getLeftChild() != null) {
            root = root.getLeftChild();
        }
        return root.getData();
    }

    public static int findKthMax(Node root, int k) {
        StringBuilder result = new StringBuilder();
        result = inOrderTraversal(root, result);
        String[] array = result.toString().split(",");
        if ((array.length - k) >= 0)
            return Integer.parseInt(array[array.length - k]);
        return -1;
    }

    public static StringBuilder inOrderTraversal(Node root, StringBuilder result) {
        if (root.getLeftChild() != null)
            inOrderTraversal(root.getLeftChild(), result);
        result.append(root.getData() + ",");

        if (root.getRightChild() != null)
            inOrderTraversal(root.getRightChild(), result);
        return result;
    }

    public static String findAncestors(Node root, int k) {
        String result = " ";
        Node tempNode = root;
        while (tempNode != null && tempNode.getData() != k) {
            result += tempNode.getData() + ",";
            if (k <= tempNode.getData()) {
                tempNode = tempNode.getLeftChild();
            } else {
                tempNode = tempNode.getRightChild();
            }
        }
        if (tempNode == null) {
            return "";
        }
        return result;
    }

    public static int findHeight(Node root) {
        if (root == null)
            return -1;
        else {
            return Math.max(findHeight(root.getLeftChild()), findHeight(root.getRightChild())) + 1;
        }
    }

    public static String findKNodes(Node root, int k) {
        StringBuilder result = new StringBuilder();
        result = findK(root, k, result);

        return result.toString();
    }

    public static StringBuilder findK(Node root, int k, StringBuilder result) {
        if (root == null)
            return null;

        if (k == 0) {
            result.append(root.getData() + ",");
        }

        else {
            findK(root.getLeftChild(), k - 1, result);
            findK(root.getRightChild(), k - 1, result);
        }
        return result;
    }

}
