package Algorithms.Recursion;

import java.util.LinkedList;

public class DFS {
    static class Graph {
        int numVertices;
        LinkedList<Integer>[] tempList;

        Graph(int numVertices){
            this.numVertices = numVertices;
            tempList = new LinkedList[numVertices];
            for(int i = 0; i < numVertices; i++){
                tempList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int target){
            tempList[source].addFirst(target);
        }

        public void DFSRecursion(int startVertex) {
            boolean[] visitedArr = new boolean[numVertices];
            dfs(startVertex, visitedArr);
        }

        public void dfs(int start, boolean[] visited){
            visited[start] = true;
            System.out.println(start + "");
            for(int i = 0; i < tempList[start].size(); i++) {
                int target = tempList[start].get(i);
                if(!visited[target])
                    dfs(target, visited);
            }

        }

        
    }
    
}
