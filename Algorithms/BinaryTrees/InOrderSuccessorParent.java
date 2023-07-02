package Algorithms.BinaryTrees;

public class InOrderSuccessorParent {
    static BinaryTreeNode treeMin(BinaryTreeNode root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    static BinaryTreeNode parentStreamSuccessor(BinaryTreeNode node){
        while(node.parent != null){
            if(node.parent.left == node){
                return node.parent;
            }
            node = node.parent;
        }
        return null;
    }

    static BinaryTreeNode findInOrderSuccessorHelper(BinaryTreeNode node){
        if(node == null){
            return null;
        }

        if(node.right != null){
            return treeMin(node.right);

        }

        return parentStreamSuccessor(node);
    }

    static BinaryTreeNode findInOrderSuccessor(BinaryTreeNode root, int predecessorData){
        while(root != null){
            if(root.data < predecessorData){
                root = root.right;
            }

            else if(root.data > predecessorData){
                root = root.left;
            } else {
                return findInOrderSuccessorHelper(root);
            }

            if(root == null){
                BinaryTreeNode temp = new BinaryTreeNode(-1);
                return temp;
            }
    }
    return null;
}
