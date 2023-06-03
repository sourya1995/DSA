public class Graph {
    int vertices; // total vertices
    DoublyLinkedListWithTail<Integer> adjacencyList[];

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedListWithTail[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new DoublyLinkedListWithTail<>();
        }
    }

    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            this.adjacencyList[source].insertAtEnd(destination);
        }
    }

    public void printGraph() {
        System.out.println("Adjacencency List of Directed Graph");
        for (int i = 0; i < vertices; i++) {
            if (adjacencyList[i] != null) { // construction of LinkedList
                System.out.println("|" + i + "| => "); // take each element from the adjacencyList array
                DoublyLinkedListWithTail<Integer>.Node temp = adjacencyList[i].getHeadNode();
                while (temp != null) {
                    System.out.println("[" + temp.data + "] -> ");
                    temp = temp.nextNode;
                } // add the linked list
                System.out.println("null");
            } else {
                System.out.println("|" + i + "| =>" + "null");
            }

        }

    }
}