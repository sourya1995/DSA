package Algorithms.BinaryTrees;

public class InOrderSuccessor {
    static BinaryTreeNode treeMin(BinaryTreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    static BinaryTreeNode findInOrderSuccessor(BinaryTreeNode root, int nodeValue) {
        if (root == null)
            return null;

        BinaryTreeNode successor = null;

        while (root != null) {
            if (root.data < nodeValue) {
                root = root.right;
            } else if (root.data > nodeValue) {
                successor = root;
                root = root.left;
            } else {
                if (root.right != null) {
                    successor = treeMin(root.right);
                }
                break;
            }
            if (root == null) {
                BinaryTreeNode temp = new BinaryTreeNode(-1);
                return temp;
            }
        }
        return successor;
    }
}
