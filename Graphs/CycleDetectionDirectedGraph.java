package Graphs;

public class CycleDetectionDirectedGraph {
    public static boolean detectCycle(Graph g) {
        int num_of_vertices = g.vertices;
        boolean[] visited = new boolean[num_of_vertices]; // array to hold visited vertices
        boolean[] stackFlag = new boolean[num_of_vertices]; // hold a flag if node is currently in stack or not

        for (int i = 0; i < num_of_vertices; i++) {
            if (cyclic(g, i, visited, stackFlag)) {
                return true;
            }
        }
        return false;
    }

    public static boolean cyclic(Graph g, int v, boolean[] visited, boolean[] stackFlag) {
        if (stackFlag[v]) {
            return true; // if node is currently in stack, we have found a cycle
        }

        if (visited[v]) {
            return false; // if node is already visited, and not in stack, no cycle
        }
/*If the stackFlag[v] is false, it checks the visited[v] array. If visited[v] is true, it means the vertex has already been visited 
and is not part of the current recursion stack, so there is no cycle. In this case, it returns false.

If neither of the above conditions is met, it marks the vertex v as visited and pushes it onto the stack by setting visited[v] 
and stackFlag[v] to true. Then, it iterates over the adjacency list of the vertex v and recursively calls the cyclic method for each 
adjacent vertex. If any of the recursive calls return true, indicating a cycle, it immediately returns true to the caller. */

        visited[v] = true;
        stackFlag[v] = true;

        DoublyLinkedListWithTail<Integer>.Node temp = null;
        if (g.adjacencyList[v] != null) {
            temp = g.adjacencyList[v].headNode;

        }

        while (temp != null) {
            if (cyclic(g, temp.data, visited, stackFlag)) { //recurse
                return true;
            }
            temp = temp.nextNode;
        }
        stackFlag[v] = false;
        return false;
        /*After the iteration is complete, it sets stackFlag[v] back to false 
        before returning false to indicate that no cycle was found. */
    }
}
