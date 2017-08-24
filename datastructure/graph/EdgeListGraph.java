package datastructure.graph;

import datastructure.listanditerator.LinkedPositionList;
import datastructure.listanditerator.Position;
import datastructure.listanditerator.PositionList;

/**
 * 
 * @author m2l
 *
 * @param <V>
 * @param <E>
 */
public class EdgeListGraph<V, E> implements Graph<V, E> {	
	
	//Variables
	private boolean isDirected;
	private PositionList<Vertex<V>> vertexList = new LinkedPositionList<>();
	private PositionList<Edge<E>> edgeList = new LinkedPositionList<>();

	public EdgeListGraph(boolean isDirected) {
		this.isDirected = isDirected;
	}

	//Private classes.
	@SuppressWarnings("hiding")
	private class InnerVertex<V> implements Vertex<V> {
		private V element;
		private Position<Vertex<V>> position;
		
		public InnerVertex(V v) {this.element = v;}
		
		@Override
		public boolean validate(Graph<V, ?> graph) {
			return (EdgeListGraph.this == graph && position != null);
		}
		
		@Override
		public V getElement() 
				throws IllegalStateException {return this.element;}
		
		@Override
		public void setPosition(Position<Vertex<V>> pos) {this.position = pos;}
		
		@Override
		public Position<Vertex<V>> getPosition() {return this.position;}
		
		@Override
		public void setElement(V v) {this.element = v;}
	}

	@SuppressWarnings("hiding")
	private class InnerEdge<E> implements Edge<E> {
		private E element;
		private Position<Edge<E>> position;
		private Vertex<V>[] endPoints;
		private boolean isDirected;
		
		@SuppressWarnings("unchecked")
		public InnerEdge(Vertex<V> u, Vertex<V> v, E e) {
			this.element = e;
			this.endPoints = (Vertex<V>[]) new Vertex[]{u,v};	
		}
		
		@Override
		public boolean validate(Graph<?, E> graph) {
			return (EdgeListGraph.this == graph && position != null);
		}
		
		@Override
		public E getElement() throws IllegalStateException {return this.element;}
		
		@Override
		public boolean isDirected() {return this.isDirected;}
		
		@Override
		public Vertex<V>[] endPoints() {return this.endPoints;}
		
		@Override
		public Position<Edge<E>> getPosition() {return this.position;}
		
		@Override
		public void setPosition(Position<Edge<E>> p) {this.position = p;}
	}
	
	//Private utilities.
	private InnerEdge<E> validate(Edge<E> e) {
		if(!(e instanceof InnerEdge)) 
			throw new IllegalArgumentException("Invalid edge.");
		InnerEdge<E> edge = (InnerEdge<E>) e;
		if(!edge.validate(this)) 
			throw new IllegalArgumentException("Invalid edge.");
		return edge;
	}
	
	@SuppressWarnings("unused")
	private InnerVertex<V> validate(Vertex<V> v) {
		if(!(v instanceof InnerVertex))
			throw new IllegalArgumentException("Invalid vertex.");
		InnerVertex<V> vertex = (InnerVertex<V>) v;
		if(!vertex.validate(this)) 
			throw new IllegalArgumentException("Invalid vertex.");
		return vertex;
	}
	
	//Interface implementation.
	@Override
	public int numVertices() {return this.vertexList.size();}

	@Override
	public int numEdges() {return this.edgeList.size();}

	@Override
	public Iterable<Vertex<V>> vertices() {return this.vertexList;}

	@Override
	public Iterable<Edge<E>> edges() {return this.edgeList;}

	@Override
	public Edge<E> getEdge(Vertex<V> v, Vertex<V> w) {
		for (Edge<E> edge : this.edgeList) {
			Vertex<V>[] vertex =  this.endVertices(edge);
			if(edge.isDirected()) 
				if(vertex[0] == v && vertex[1] == w)
					return edge;
			else
				if(vertex[0] == v && vertex[1] == w || vertex[0] == w && vertex[1] == v);
					return edge;
		}
		return null; 
	}
	
	@Override
	public Vertex<V>[] endVertices(Edge<E> e) {
		InnerEdge<E> edge = validate(e);
		return (Vertex<V>[]) edge.endPoints();
	}

	@Override
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException {
		InnerEdge<E> edge = validate(e);
		Vertex<V>[] endpoints = edge.endPoints();
		
		if(endpoints[0] == v)
			return endpoints[1];
		else if(endpoints[1] == v)
			return endpoints[0];
		else
			throw new IllegalArgumentException("This vertex is not incident to edge.");
	}

	@Override
	public int outDegree(Vertex<V> v) {
		int count = 0;
		for (Edge<E> edge : this.edgeList) {
			Vertex<V>[] endPoints = this.endVertices(edge);
			if(!this.isDirected) 
				if(endPoints[0] == v || endPoints[0] == v) 
					count++;
			else
				if(endPoints[0] == v) count++;
		}
		return count;
	}

	@Override
	public int inDegree(Vertex<V> v) {
		if(!this.isDirected) 
			return this.outDegree(v);
		else {
			int count = 0;
			for (Edge<E> edge : this.edgeList) {
				Vertex<V>[] endPoints = this.endVertices(edge);
				if(endPoints[1] == v) count++;
			}
			return count;
		}
	}

	@Override
	public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) {
		return null;
	}

	@Override
	public Iterable<Edge<E>> incomingEdges(Vertex<V> v) {
		return null;
	}

	@Override
	public Vertex<V> insertVertex(V x) {
		InnerVertex<V> newVertex = new InnerVertex<>(x); 
		Position<Vertex<V>> position = this.vertexList.addLast(newVertex);
		newVertex.setPosition(position);
		return newVertex;
	}

	@Override
	public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E e) throws IllegalArgumentException {
		if(this.getEdge(u, v) == null) {
			InnerEdge<E> newEdge = new InnerEdge<>(u ,v ,e);
			Position<Edge<E>> pos = this.edgeList.addLast(newEdge); 
			newEdge.setPosition(pos);
			return newEdge;
		} else 
			throw new IllegalArgumentException("Edge from u to v exists.");
	}

	@Override
	public void removeVertex(Vertex<V> v) {
		edgeList.forEach(edge -> {
			Vertex<V>[] vertex =  this.endVertices(edge);
			if(vertex[0] == v || vertex[1] == v) this.removeEdge(edge);
		});
		this.vertexList.remove(v.getPosition());
	}

	@Override
	public void removeEdge(Edge<E> e) {
		edgeList.remove(e.getPosition());
	}
}


