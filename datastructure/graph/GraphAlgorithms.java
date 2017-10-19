package datastructure.graph;

import java.util.Set;

import datastructure.map.Map;

public class GraphAlgorithms {
	public static <V,E> void DFS(Graph<V, E> 				graph, 
								 Vertex<V> 					u, 
								 Set<Vertex<V>> 			known, 
								 Map<Vertex<V>, Edge<E>> 	forest) 
	{
		known.add(u);
		for (Edge<E> e: graph.outgoingEdges(u)) {
			Vertex<V> v = graph.opposite(u, e);
			if(!known.contains(v)) {
				forest.put(v, e);
				DFS(graph, v, known, forest);
			}
		}
	}
}
