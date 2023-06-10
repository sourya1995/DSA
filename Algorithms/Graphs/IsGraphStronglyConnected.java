package Algorithms.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class IsGraphStronglyConnected {
    public static void utilityFunction(Graph graph, int v, boolean visited[]) {
        visited[v] = true;
        int temp;
        LinkedList<Integer> linkedList[];
        linkedList = graph.getAdjacencyList();
        Iterator<Integer> it = linkedList[v].iterator();
        while (it.hasNext()) {
            temp = it.next();
            if (!visited[temp]) {
                utilityFunction(graph, temp, visited);
            }
        }

    }

    public static Object isStronglyConnected(Graph graph) {
        int num_of_vertices = graph.getVertices();
        boolean visited[] = new boolean[num_of_vertices];
        utilityFunction(graph, 0, visited);
        for (int i = 0; i < num_of_vertices; i++)
            if (visited[i] == false)
                return false;

        Graph graph2 = graph.getTranspose();
        for (int i = 0; i < num_of_vertices; i++)
            visited[i] = false;

        utilityFunction(graph2, 0, visited);

        for (int i = 0; i < num_of_vertices; i++)
            if (visited[i] == false)
                return false;

        return true;
    }
}
