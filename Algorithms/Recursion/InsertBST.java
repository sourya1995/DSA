package Algorithms.Recursion;

import Trees.Node;

public class InsertBST {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node recursive_insert (Node currentNode, int value) {
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

    public boolean insert(int value){
        root = recursive_insert(this.root, value);
        return true;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void printTree(Node current){
        if(current == null) return;
        System.out.println(current.getData() + "");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());
    }

    
}
