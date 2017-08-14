package datastructure.graph;

import java.util.Iterator;

import datastructure.graph.edgelist.Edge;
import datastructure.graph.edgelist.Vertex;

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
	
	public Iterable<Vertex<V, E>> vertices();
	public Iterable<Edge<E, V>> edges();
	public Iterable<Edge<E, V>> incidentEdges(Vertex<V, E> v);
	public Vertex<V, E> opposite(Vertex<V, E> v, Edge<E, V> e) throws Exception;
	public Vertex<V, E>[] endVertices(Edge<E, V> e) throws Exception;
	public boolean areAdjacent(Vertex<V, E> v, Vertex<V, E> w);
	public void replace(Vertex<V, E> v, V x);
	public void replace(Edge<E, V> e, E x);
	public Vertex<V, E> insertVertex(V x);
	public Edge<E, V> insertEdge(Vertex<V, E> v, Vertex<V, E> w, E x);
	public V removeVertex(Vertex<V, E> v);
	public E removeEdge(Edge<E, V> e);
	
}
