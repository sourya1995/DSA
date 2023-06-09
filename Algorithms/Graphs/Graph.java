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
        for (int i = 0; i < vertices; i++) {
            if (adjacencyList[i] != null) {
                System.out.println("|" + i + "| => ");
                DoublyLinkedList<Integer>.Node temp = adjacencyList[i].getHeadNode();
                while (temp != null) {
                    System.out.println("[" + temp.data + "] ->");
                    temp = temp.nextNode;
                }
                System.out.println("null");
            } else {
                System.out.println("|" + i + "| =>" + "null");
            }
        }
    }

    public int getVertices(){
        return this.vertices;
    }

    public LinkedList<Integer> []getAdjacencyList() {
        return this.adjacencyList;
    }

}
