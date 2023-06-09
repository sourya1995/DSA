package Algorithms.Graphs;

public class BFS {
    public static String doBFS(Graph graph) {
        String result = "";
        if (graph.vertices < 1) {
            return result;
        }

        boolean[] visited = new boolean[graph.vertices];
        for (int i = 0; i < graph.vertices; i++) {
            if (!visited[i]) {
                result += bfsVisit(graph, i, visited);
            }
        }
        return result;

    }

    public static String bfsVisit(Graph graph, int source, boolean[] visited) {
        String result = "";

        Queue<Integer> queue = new Queue<>(graph.vertices);
        queue.enqueue(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int current_node = queue.dequeue();
            result += String.valueOf(current_node);
            DoublyLinkedList<Integer>.Node temp = null;
            if (graph.adjacencyList[current_node] != null)
                temp = graph.adjacencyList[current_node].headNode;

            while (temp != null) {
                if (!visited[temp.data]) {
                    queue.enqueue(temp.data);
                    visited[temp.data] = true;
                }
                temp = temp.nextNode;
            }

        }
        return result;

    }
}