package Graphs;

public class BreadthFirstSearch {
    public static String bfs(Graph g) {
        String result = " ";
        if (g.vertices < 1) {
            return result;
        }

        boolean[] visited = new boolean[g.vertices]; // boolean array to store visited vertices
        for (int i = 0; i < g.vertices; i++) {

            if (!visited[i]) { // if current vertex is not visited
                result += bfsVisit(g, i, visited);
            }
        }
        return result;

    }

    public static String bfsVisit(Graph g, int source, boolean[] visited) {
        String result = " ";

        Queue<Integer> queue = new Queue<>(g.vertices); // queue for BFS
        queue.enqueue(source); // add source vertex to queue
        visited[source] = true;

        while (!queue.isEmpty()) { // traverse only when queue is not empty
            int current_node = queue.dequeue(); // remove an element from queue and add to result
            result += String.valueOf(current_node);

            DoublyLinkedListWithTail<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;
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
