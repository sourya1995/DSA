package Algorithms.Graphs;

public class RemoveAnEdge {
    public static boolean isConnected(Graph graph) {
        int num_of_vertices = graph.getVertices();
        boolean visited[] = new boolean[num_of_vertices];
        graph.dfsTraversal(0, visited);
        for (int i = 1; i < num_of_vertices; i++)
            if (visited[i] == false) {
                return false;
            }

        return true;
    }

    public static Object willCauseSeparateComponents(Graph graph, int source, int destination) {
        graph.getAdjacencyList()[source].remove(graph.getAdjacencyList()[source].indexOf(destination));
        graph.getAdjacencyList()[destination].remove(graph.getAdjacencyList()[destination].indexOf(source));
        boolean result = isConnected(graph);

        if (result == false) {
            return true;
        } else {
            return false;
        }
    }

}
