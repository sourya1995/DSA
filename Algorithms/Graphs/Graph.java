package Algorithms.Graphs;

public class Graph {
    int vertices;
    DoublyLinkedList<Integer> adjacencyList[];

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new DoublyLinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            this.adjacencyList[source].insertAtEnd(destination);
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

}
