package Graphs;

public class FindShortestPath {
    public static int findMin(Graph g, int source, int destination){
        if(source == destination){
            return 0;
        }

        int result = 0;
        int num_of_vertices = g.vertices;

        boolean[] visited = new boolean[num_of_vertices];
        int[] distance = new int[num_of_vertices];

        Queue<Integer> queue = new Queue<>(num_of_vertices);
        queue.enqueue(source);
        visited[source] = true;

        while(!queue.isEmpty()){
            int current_node = queue.dequeue();
            DoublyLinkedListWithTail<Integer>.Node temp = null;
            if(g.adjacencyList[current_node] != null){
                temp = g.adjacencyList[current_node].headNode;
            }
            while(temp != null){
                if(!visited[temp.data]){
                    queue.enqueue(temp.data);
                    visited[temp.data] = true;
                    distance[temp.data] = distance[current_node] + 1;
                }
                if(temp.data == destination){
                    return distance[destination];
                }
                temp = temp.nextNode;
            }
        }
        return -1;
    }
}
