package Algorithms.Graphs;

import java.util.LinkedList;

public class CountPathsBetweenTwoNodes {
    public static int countPaths(Graph graph, int start, int destination) {
        int count = 0;
        return countPathsRecursive(graph, start, destination, count);
    }

    public static int countPathsRecursive(Graph graph, int start, int destination, int count) {
        LinkedList<Integer> linkedList[];
        linkedList = graph.getAdjacencyList();

        if (start == destination) {
            count++;
        }

        else {
            for (int i = 0; i < linkedList[start].size(); i++) {
                int adjacentVertex = linkedList[start].get(i);
                count = countPathsRecursive(graph, adjacentVertex, destination, count);
            }
        }
        return count;
    }
}
