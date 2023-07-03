package Algorithms.BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void LevelOrderTraversal(BinaryTreeNode root){
        if(root == null){
            System.out.println( "null");
        }

        else{
            ArrayList<Queue<BinaryTreeNode>> queues = new ArrayList<Queue<BinaryTreeNode>>();
            queues.add(new ArrayDeque<BinaryTreeNode>());
            queues.add(new ArrayDeque<BinaryTreeNode>());

            Queue<BinaryTreeNode> current_queue = queues.get(0);
            Queue<BinaryTreeNode> next_queue = queues.get(1);

            current_queue.add(root);
            int level_number = 0;

            while(!current_queue.isEmpty()){
                BinaryTreeNode temp = current_queue.poll();
                System.out.println(temp.data);

                if(temp.left != null){
                    next_queue.add(temp.left);
                }

                if(temp.right != null){
                    next_queue.add(temp.right);
                }

                if(current_queue.isEmpty()){
                    level_number++;
                    if(!next_queue.isEmpty()){
                        System.out.print(":");
                    }
                    current_queue = queues.get(level_number % 2);
                    next_queue = queues.get((level_number + 1) % 2);
                }else{
                    System.out.println(",");
                }
            }
        }
    }
}
