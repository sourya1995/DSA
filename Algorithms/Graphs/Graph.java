package Algorithms.Graphs;

import java.util.LinkedList;

public class Graph {
    int vertices;
    LinkedList<Integer> adjacencyList[];

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            this.adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            this.adjacencyList[source].add(destination);
        }
    }

    public void printGraph() {
        System.out.println("Adjacency list of directed graph: ");
        for (int v = 0; v < this.vertices; v++) {
           System.out.println(v);
           for(Integer pCrawl : this.adjacencyList[v]) {
                System.out.println("->" + pCrawl);
           }
           System.out.println("\n");
        }
    }

    public int getVertices(){
        return this.vertices;
    }

    public LinkedList<Integer> []getAdjacencyList() {
        return this.adjacencyList;
    }

}
