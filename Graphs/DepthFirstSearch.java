package Graphs;

public class DepthFirstSearch {
    public static String dfs(Graph g) {
        String result = " ";
        if (g.vertices < 1) {
            return result;
        }

        boolean[] visited = new boolean[g.vertices];
        for (int i = 0; i < g.vertices; i++) {
            if (!visited[i]) {
                result += dfsVisit(g, i, visited);
            }

        }
        return result;

    }

    public static String dfsVisit(Graph g, int source, boolean[] visited) {
        String result = " ";
        Stack<Integer> stack = new Stack<>(g.vertices); // construct stack to store vertices
        stack.push(source); // push source vertex to stack

        while (!stack.isEmpty()) {
            int current_node = stack.pop();
            result += String.valueOf(current_node);

            DoublyLinkedListWithTail<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;

            while (temp != null) {
                if (!visited[temp.data]) { //push node ONLY if NOT visited
                    stack.push(temp.data);
                }
                temp = temp.nextNode;
            }
            visited[current_node] = true;
        }
        return result;
    }
}