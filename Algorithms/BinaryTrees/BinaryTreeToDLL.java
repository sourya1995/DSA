package Algorithms.BinaryTrees;

public class BinaryTreeToDLL {
    public static BinaryTreeNode first = null;
    public static BinaryTreeNode last = null;

    public static void convertToDLLRec(BinaryTreeNode node) {
        if(node == null){
            return;
        } else {
            convertToDLL(node.left);

            if(last != null){
                last.right = node;
                node.left = last;
            } else{
                first = node;
            }

            last = node;
            convertToDLL(node.right);
        }
    }

    public static BinaryTreeNode convertToDLL(BinaryTreeNode root){
        if(root == null) {
            return null;
        } else {
            first = null;
            last = null;
            convertToDLL(root);

            last.right = null;
            first.left = null;
            return first;
        }
    }
}
