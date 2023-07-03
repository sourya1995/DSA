package Algorithms.BinaryTrees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LCA {
    public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
        if(root == null || node1 == null || node2 == null){
            return null;
        }

        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        Map<BinaryTreeNode, BinaryTreeNode> parent = new HashMap<>();
        parent.put(root, null);
        stack.push(root);

        while(!parent.containsKey(node1) || !parent.containsKey(node2)){
            BinaryTreeNode node = stack.pop();
            if(node.left != null){
                parent.put(node.left, node);
                stack.push(node.left);
            }

            if(node.right != null){
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<BinaryTreeNode> ancestors = new HashSet<>();
        while(node1 != null){
            ancestors.add(node1);
            node1 = parent.get(node1);
        }

        while(!ancestors.contains(node2)){
            node2 = parent.get(node2);
            return node2;
        }
}
