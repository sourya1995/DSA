package Trees;

class Node {
    int data;
    Node left;
    Node right;
    Node parent;
    boolean color;

    public Node(int data){
        this.data = data;
    }
}

public class RedBlackTree {
    private void rotateRight(Node node){
        Node parent = node.parent;
        Node leftChild = node.left;

        node.left = leftChild.right;
        if(leftChild.right != null){
            leftChild.right.parent = node;
        }

        leftChild.right = node;
        node.parent = leftChild;
        replaceParentsChild(parent, node, leftChild);
    }

    private void replaceParentsChild(Node parent, Node oldChild, Node newChild) {
       //TODO: implement the rest later
    }
}
