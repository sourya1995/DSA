package Graphs;

public class IsGraphTreeBFS {
    public static boolean isGraphTree(Graph g) {
        int root = 0;
        boolean[] visited = new boolean[g.vertices];
        Queue<Integer> queue = new Queue<>(g.vertices);

        queue.enqueue(root);
        visited[root] = true;

        int numberOfVisited = 1;
        while (!queue.isEmpty()) {
            int current_node = queue.dequeue();
            DoublyLinkedListWithTail<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null) {
                temp = g.adjacencyList[current_node].headNode;
            }
            while (temp != null) {
                if (!visited[temp.data]) {
                    queue.enqueue(temp.data);
                    visited[temp.data] = true;
                    numberOfVisited++;
                } else {
                    return false;
                }
                temp = temp.nextNode;
            }
        }
        if (numberOfVisited == g.vertices) { //is graph connected
            return true;

        }
        return false;

    }
}
