package Graphs;

import java.util.Arrays;

public class MotherVertex {
    public static int findMotherVertex(Graph g) {
        boolean[] visited = new boolean[g.vertices];
        Arrays.fill(visited, false);
        int lastV = 0; // to store MotherVertex

        for (int i = 0; i < g.vertices; i++) {
            if (visited[i] == false) {
                DFS(g, i, visited);
                lastV = i;
            }
        }

        // We need to check if all the vertices can be visited from lastV
        Arrays.fill(visited, false);
        DFS(g, lastV, visited);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                return -1;
            }
        }
        return lastV;

    }

    public static void DFS(Graph g, int node, boolean[] visited) {
        visited[node] = true;
        DoublyLinkedListWithTail<Integer>.Node temp = null;
        if (g.adjacencyList[node] != null) {
            temp = g.adjacencyList[node].headNode;
        }
        while (temp != null) {
            if (visited[temp.data]) {
                temp = temp.nextNode;
            } else {
                visited[temp.data] = true;
                DFS(g, temp.data, visited);
                temp = temp.nextNode;
            }
        }
    }
}
