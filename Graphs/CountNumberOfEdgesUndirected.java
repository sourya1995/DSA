package Graphs;

public class CountNumberOfEdgesUndirected {
    public static int numEdges(Graph g){
        int sum = 0;

        for(int i=0; i<g.vertices; i++){
            DoublyLinkedListWithTail<Integer>.Node temp = null;
            if(g.adjacencyList[i] != null){
                temp = g.adjacencyList[i].headNode;
            } 
            while(temp != null){
                sum++;
                temp = temp.nextNode;
            }
        }
        return sum/2; //in an undirected graph, number of edges is always even, as edges are bidirectional. So we divide by 2.
    }
    
}
