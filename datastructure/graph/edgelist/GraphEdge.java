package datastructure.graph.edgelist;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import datastructure.graph.Graph;

public class GraphEdge<V, E> implements Graph<V, E> {
	private Map<Edge<E, V>, List<Vertex<V, E>>> edgeMap = new HashMap<>();
	
	public GraphEdge() {
		edgeMap.put(null, new LinkedList<>());
	}
	
	@Override
	public Iterator<Vertex<V, E>> vertices() {
		return this.edgeMap.get(null).iterator();
	}

	@Override
	public Iterator<Edge<E, V>> edges() {
		return this.edgeMap.keySet().iterator();
	}

	@Override
	public Iterator<Edge<E, V>> incidentEdges(Vertex<V, E> v) {
		return v.incidentList();
	}

	@Override
	public Vertex<V, E> opposite(Vertex<V, E> v, Edge<E, V> e) throws Exception {
		if(e.equals(null))
			throw new Exception("Edge not is valid.");
		if(!this.edgeMap.get(e).contains(v))
			throw new Exception("This edge not is incident in this vertex.");
		return this.edgeMap.get(e).get(0).equals(v) ? this.edgeMap.get(e).get(0) : this.edgeMap.get(e).get(1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vertex<V, E>[] endVertices(Edge<E, V> e) throws Exception {
		if(e.equals(null))
			throw new Exception("Edge not is valid.");
		return (Vertex<V, E>[]) this.edgeMap.get(e).toArray();
	}

	@Override
	public boolean areAdjacent(Vertex<V, E> v, Vertex<V, E> w) {
		for (List<Vertex<V, E>> vertices : edgeMap.values())
			if(vertices.contains(v) && vertices.contains(w))
				return true;
		return false;
	}

	@Override
	public void replace(Vertex<V, E> v, V x) {
	}

	@Override
	public void replace(Edge<E, V> e, E x) {
		
	}

	@Override
	public Vertex<V, E> insertVertex(V x) {
		return null;
	}

	@Override
	public Edge<E, V> insertEdge(Vertex<V, E> v, Vertex<V, E> w, E x) {
		return null;
	}

	@Override
	public V removeVertex(Vertex<V, E> v) {
		return null;
	}

	@Override
	public E removeEdge(Edge<E, V> e) {
		return null;
	}
		
}
