package Algorithms.Graphs;

public class IsGraphBipartite {
    public static Object isBipartite(Graph graph, int source, boolean visited[], boolean color[]) {
        for (int u : graph.getAdjacencyList()[source]) {
            if (visited[u] == false) {
                visited[u] = true;
                color[u] = !color[source];

                if (String.valueOf(isBipartite(graph, u, visited, color)) == "false") {
                    return false;
                }

                else if (color[source] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }

}
