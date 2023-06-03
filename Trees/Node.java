package Trees;

public class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;

    Node(int value){
        this.data = value;
        leftChild = null;
        rightChild = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int value) {
        this.data = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node left) {
        this.leftChild = left;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node right) {
        this.rightChild = right;
    }
}
