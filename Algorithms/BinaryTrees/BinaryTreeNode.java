package Algorithms.BinaryTrees;

public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode next;
    public BinaryTreeNode parent;
    public int count;

    public BinaryTreeNode(int d){
        data = d;
        left = null;
        right = null;
        next = null;
        parent = null;
        count = 0;
    }
}
