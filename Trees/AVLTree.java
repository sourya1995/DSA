package Trees;

import java.lang.Math.*;

class Node {
    int data;
    Node left;
    Node right;
    int height;

    public Node(int data) {
        this.data = data;
    }
}

public class AVLTree {
    private int height(Node node) {
        return node != null ? node.height : -1;
    }

    private void updateHeight(Node node) {
        int leftChildHeight = height(node.left);
        int rightChildHeight = height(node.right);
        node.height = max(leftChildHeight + rightChildHeight) + 1;
    }

    private int balanceFactor(Node node) {
        return height(node.right) - height(node.left);
    }

    private Node rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        updateHeight(node);
        updateHeight(leftChild);
        return leftChild;
    }

    private Node rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        updateHeight(node);
        updateHeight(rightChild);
        return rightChild;
    }

    private Node rebalance(Node node) {
        int balanceFactor = balanceFactor(node);

        if (balanceFactor < -1) { // LEFT-HEAVY
            if (balanceFactor(node.left) <= 0) { // left-left
                node = rotateRight(node);
            } else {// left-right
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }

        if (balanceFactor > 1) { // RIGHT-HEAVY
            if (balanceFactor(node.right) >= 0) { // right-right
                node = rotateLeft(node);
            } else {// right-left
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        return node;
    }

    Node insertNode(int key, Node node){
        //node = BinarySearchTree.add(key);
        updateHeight(node);
        return rebalance(node);
    }

    Node deleteNode(int key, Node node){
        //node = BinarySearchTree.delete(key);
        if(node == null){
            return null;
        }
        updateHeight(node);
        return rebalance(node);
    }
}
