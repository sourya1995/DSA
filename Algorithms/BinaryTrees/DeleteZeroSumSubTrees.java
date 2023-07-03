package Algorithms.BinaryTrees;

public class DeleteZeroSumSubTrees {
    public static int deleteZeroSumSubTree(BinaryTreeNode node){
        if(node == null){
            return 0;
        }

        int sumLeft = deleteZeroSumSubTree(node.left);
        int sumRight = deleteZeroSumSubTree(node.right);

        if(sumLeft == 0){
            node.left = null;
        }

        if(sumRight == 0){
            node.right = null;
        }

        return node.data + sumLeft + sumRight;

    }

    public static void deleteZeroSumTree(BinaryTree tree){
        if(tree == null || tree.root == null){
            return;
        }

        int treeSum = deleteZeroSumSubTree(tree.root);

        if(treeSum == 0){
            tree.root = null;
        }
    }
}
