package Algorithms.BinaryTrees;

public class IdenticalTrees {
    public static boolean areIdentical(BinaryTreeNode tree1, BinaryTreeNode tree2) {
        if(tree1 == null && tree2 == null){
            return true;
        }

        if(tree1 != null && tree2 != null){
            return (areIdentical(tree1.left, tree2.left) &&  areIdentical(tree1.right, tree2.right) && tree1.data == tree2.data);
        }

        return false;
}
}
