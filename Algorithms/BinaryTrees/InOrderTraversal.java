package Algorithms.BinaryTrees;

import java.util.Stack;

public class InOrderTraversal {
    static void iterativeInOrder(BinaryTreeNode root){
        if(root == null) {
            System.out.println("null");
        } else{
            Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
            BinaryTreeNode currNode = root;
            while(!stack.isEmpty()|| currNode != null){
                if(currNode != null){
                    stack.push(currNode);
                    currNode = currNode.left;
                    continue;
                }

                System.out.println(stack.peek().data);
                currNode = stack.pop().right;

                if(!stack.isEmpty() && currNode == null){
                    System.out.println(",");
                }
            }
            
        }
    }
}
