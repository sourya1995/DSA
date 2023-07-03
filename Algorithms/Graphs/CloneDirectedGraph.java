package Algorithms.Graphs;

import java.util.HashMap;

public class CloneDirectedGraph {
    	private Node<X> cloneRec(Node<X> root, DirectedGraph<X> graph,
			HashMap<Node<X>, Node<X>> nodesCompleted) {

                if(root == null) return null;

                Node<X> pNew = new Node<X>(root.data);
                nodesCompleted.put(pNew, root);
                graph.addVertexInNodes(pNew);

                for(Node<X> p : root.neighbors){
                    Node<X> x = nodesCompleted.get(p);
                    if(x == null){
                        pNew.neighbors.add(cloneRec(p, graph, nodesCompleted));
                    } else{
                        pNew.neighbors.add(x);
                    }
                }

                return pNew;
            }

            public DirectedGraph<X> clone(DirectedGraph<X> graph){
                HashMap<Node<X>, Node<X>> nodesCompleted = new HashMap<Node<X>, Node<X>>();
                DirectedGraph<X> cloneGraph = new DirectedGraph<X>();

                if(graph.nodes.isEmpty()){
                    return cloneGraph;
                }

                cloneRec(graph.nodes.get(0), cloneGraph, nodesCompleted);
                return cloneGraph;
            }
}
