package Graphs;

public class IsGraphTree {
    public static boolean isTree(Graph g) {
        if (!checkOneParent(g)) {
            return false;
        }

        if (detectCycle(g)) {
            return false;
        }

        if (!checkConnected(g, 0)) {
            return false;
        }

        return true;

    }

    public static boolean detectCycle(Graph g) {
        int number_of_vertices = g.vertices;
        boolean[] visited = new boolean[number_of_vertices];
        boolean[] stackFlag = new boolean[number_of_vertices];

        for (int i = 0; i < number_of_vertices; i++) {
            if (cyclic(g, i, visited, stackFlag)) {
                return true;
            }

        }
        return false;
    }

    public static boolean cyclic(Graph g, int v, boolean[] visited, boolean[] stackFlag) {
        if (stackFlag[v]) {
            return true;
        }

        if (visited[v]) {
            return false;
        }

        visited[v] = true;
        stackFlag[v] = true;

        DoublyLinkedListWithTail<Integer>.Node temp = null;
        if (g.adjacencyList[v] != null) {
            temp = g.adjacencyList[v].headNode;
        }

        while (temp != null) {
            if (cyclic(g, v, visited, stackFlag)) {
                return true;
            }
            temp = temp.nextNode;
        }
        stackFlag[v] = false;
        return false;
    }

    public static boolean checkOneParent(Graph g) {
        int num_of_vertices = g.vertices;
        boolean[] hasOneParent = new boolean[num_of_vertices];

        for (int i = 0; i < num_of_vertices; i++) {
            DoublyLinkedListWithTail<Integer>.Node temp = null;
            if (g.adjacencyList[i] != null) {
                temp = g.adjacencyList[i].headNode;
                while (temp != null) {
                    if (hasOneParent[temp.data] == true) {
                        return false;
                    }
                    hasOneParent[temp.data] = true;
                    temp = temp.nextNode;
                }

            }
        }
        for (int i = 0; i < num_of_vertices; i++) {
            if (i == 0 && hasOneParent[i] == true) {
                return false;
            } else if (i != 0 && hasOneParent[i] == false) {
                return false;
            }
        }

        return true;

    }

    private static boolean checkConnected(Graph g, int source) {
        int num_of_vertices = g.vertices;
        int vertices_reached = 0;

        boolean[] visited = new boolean[num_of_vertices];
        Stack<Integer> stack = new Stack<>(num_of_vertices);
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
                    stack.push(temp.data);
                    visited[temp.data] = true;
                    vertices_reached++;
                }

                temp = temp.nextNode;
            }
        }
        return (vertices_reached + 1) == g.vertices;
    }
}
