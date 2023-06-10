package Algorithms.Graphs;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {
    public static void utilityFunction(Graph graph, int v, boolean visited[], Stack<Integer> myStack) {
        visited[v] = true;
        Iterator<Integer> i = graph.getAdjacencyList()[v].iterator();
        Integer temp;
        while (i.hasNext()) {
            temp = i.next();
            if (!visited[temp]) {
                utilityFunction(graph, temp, visited, myStack);
            }
            myStack.push(v);
        }
    }

    @SuppressWarnings("unchecked")
    public static void topologicalSort(Graph graph) {
        Stack<Integer> myStack = new Stack<>();
        int num_of_vertices = graph.getVertices();
        boolean visited[] = new boolean[num_of_vertices];
        for (int i = 0; i < num_of_vertices; i++) {
            if (visited[i] == false) {
                utilityFunction(graph, i, visited, myStack);
            }
        }
        while (myStack.empty() == false) {
            System.out.println(myStack.pop() + "");
        }

    }

}
