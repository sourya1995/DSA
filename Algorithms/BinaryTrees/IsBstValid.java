package Algorithms.BinaryTrees;

public class IsBstValid {
    static BinaryTreeNode prev = null;
    public static boolean isBstRec(BinaryTreeNode root) {
        if(root == null) return true;

        if(!isBstRec(root.left)){
            return false;
        }

        if(prev != null && prev.data >= root.data){
            return false;
        }

        prev = root;

        return isBstRec(root.right);
    }

    public static boolean isBstRec(BinaryTreeNode root) {
        prev = null;
        return isBstRec(root);
    }
}
