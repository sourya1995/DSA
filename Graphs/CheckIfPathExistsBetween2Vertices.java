package Graphs;

public class CheckIfPathExistsBetween2Vertices {
    public static boolean checkPath(Graph g, int source, int destination) {
        if (source == destination) {
            return true;
        }

        boolean[] visited = new boolean[g.vertices];
        Stack<Integer> stack = new Stack<>(g.vertices);

        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            int current_node = stack.pop();
            DoublyLinkedListWithTail<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null) {
                temp = g.adjacencyList[current_node].headNode;
            }
            while (temp != null) {
                if (!visited[temp.data]) {
                    if (temp.data == destination) {
                        return true;
                    }
                    stack.push(temp.data);
                    visited[temp.data] = true;
                }
                temp = temp.nextNode;
            }
        }
        return false;
    }
}
