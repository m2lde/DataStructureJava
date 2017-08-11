package datastructure.graph;

import java.util.Collection;

import datastructure.node.DLNode;
/**
 * 
 * @author m2l
 * 
 * Simplified TAD for non-directive Graph
 *
 * @param <E>
 * @param <V>
 */
public interface Graph<V, E> {
	
	/**
	 * 
	 * @return an iterable collection of all vertex in the graph.
	 */
	public Iterable<Vertex<V>> vertices();
	
	/**
	 * 
	 * @return an iterable collection of all edges in the graph.
	 */
	public Iterable<Edge<E>> edges();
	
	/**
	 * 
	 * @param v
	 * @return an collection of edges incidents under the v node.
	 */
	public Collection<Edge<E>> incidentEdges(Vertex<V> v);
	
	/**
	 * S
	 * @return the final node of edge separated from the node v.
	 */
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e);
	
	public Vertex<V>[] endVertices(Edge<E> e);
	
	public boolean areAdjacent(Vertex<V> v, Vertex<V> w);
	
	public void replace(Vertex<V> v, V x);
	
	public void replace(Edge<E> v, E x);
	
	public void insertVertex(V x);
	
	public void insertEdge(E x);
	
	
}
