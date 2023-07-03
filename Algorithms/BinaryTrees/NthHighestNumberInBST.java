package Algorithms.BinaryTrees;

public class NthHighestNumberInBST {
    public static BinaryTreeNode findNthHighestInBst(BinaryTreeNode root, int n){
        if(root == null) return null;
        int leftCount = 0;

        if(root.left != null){
            leftCount = root.left.count;
        }

        int k = root.count - leftCount;

        if(k == n){
            return root;
        } else if(k > n){
            return findNthHighestInBst(root.right, n);

        } else {
            return findNthHighestInBst(root.left, n-k);
        }
    }
}
