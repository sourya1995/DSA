package Algorithms.Graphs;

public class DFS {
    public static String doDFS(Graph graph) {
        String result = "";
        if (graph.vertices < 1) {
            return result;
        }

        boolean[] visited = new boolean[graph.vertices];
        for (int i = 0; i < graph.vertices; i++) {
            if (!visited[i]) {
                result += dfsVisit(graph, i, visited);
            }
        }
        return result;
    }

    public static String dfsVisit(Graph graph, int source, boolean[] visited) {
        String result = "";
        Stack<Integer> stack = new Stack<Integer>(graph.vertices);
        stack.push(source);
        while (!stack.isEmpty()) {
            int current_node = stack.pop();
            result += String.valueOf(current_node);
            DoublyLinkedList<Integer>.Node temp = null;
            if (graph.adjacencyList[current_node] != null) {
                temp = graph.adjacencyList[current_node].headNode;
                while (temp != null) {
                    if (!visited[temp.data]) {
                        stack.push(temp.data);
                    }
                    temp = temp.nextNode;
                }
                visited[current_node] = true;
            }

        }
        return result;

    }
}
