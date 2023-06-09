package Algorithms.Graphs;

import java.util.LinkedList;

import java.util.Iterator;

public class NumberOfNodesInAGivenLevel {
    public static int numberOfNodesInAGivenLevel(Graph graph, int source, int level) {
        int count = 0;
        int num_of_vertices = graph.getVertices();
        int visited[] = new int[num_of_vertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[source] = 1;
        queue.add(source);
        while (queue.size() != 0) {
            source = queue.poll();
            LinkedList<Integer> linkedList[];
            linkedList = graph.getAdjacencyList();
            Iterator<Integer> i = linkedList[source].listIterator();

            while (i.hasNext()) {
                int temp = i.next();
                if (visited[temp] != 1) {
                    visited[temp] = visited[source] + 1;
                    if (visited[temp] < level) {
                        queue.add(temp);
                    }
                }
            }

        }
        for (int i = 0; i < num_of_vertices; i++) {
            if (visited[i] == level) {
                count++;
            }

        }

        return count;

    }
}
