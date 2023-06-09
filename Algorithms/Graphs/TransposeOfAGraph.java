package Algorithms.Graphs;

import java.util.LinkedList;

public class TransposeOfAGraph {
    public static void getTranspose(Graph graph){
        int num_of_vertices = graph.getVertices();
        Graph transposedGraph = new Graph(num_of_vertices);
        LinkedList<Integer> linkedList[];
        linkedList = graph.getAdjacencyList();
        for(int v=0; v < graph.getVertices(); v++){
            for(int i=0; i < linkedList[v].size(); i++){
                transposedGraph.addEdge(linkedList[v].get(i), v);
            }
        }

        transposedGraph.printGraph();
        
    }
}
