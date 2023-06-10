package Algorithms.Graphs;

import java.util.LinkedList;

public class PrintConnectedComponents {
    public static void printConnectedComponents(Graph graph) {
        int num_vertices = graph.getVertices();
        boolean[] visited = new boolean[num_vertices];
        for (int i = 0; i < num_vertices; i++) {
            if (!visited[i]) {
                utilityFunction(graph, i, visited);
                System.out.println();
            }

        }
    }

    public static void utilityFunction(Graph graph, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        LinkedList<Integer> linkedList[];
        linkedList = graph.getAdjacencyList();
        for (int i : linkedList[v]) {
            if (!visited[i]) {
                utilityFunction(graph, i, visited);
            }
        }
    }
}
