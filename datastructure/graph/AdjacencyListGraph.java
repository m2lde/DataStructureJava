package datastructure.graph;

import datastructure.lists.LinkedPositionalList;
import datastructure.lists.Position;
import datastructure.lists.PositionalList;

/**
 * 
 * @author m2l
 *
 * @param <V>
 * @param <E>
 */
public class AdjacencyListGraph<V, E> implements Graph<V, E> {	
	
	//Variables
	private boolean isDirected;
	private PositionalList<Vertex<V>> vertexList = new LinkedPositionalList<>();
	private PositionalList<Edge<E>> edgeList = new LinkedPositionalList<>();

	public AdjacencyListGraph(boolean isDirected) {
		this.isDirected = isDirected;
	}

	//Private classes.
	@SuppressWarnings("hiding")
	private class InnerVertex<V> implements Vertex<V> {
		private V element;
		private PositionalList<Edge<E>> incoming, outgoing;
		private Position<Vertex<V>> position;
		
		public InnerVertex(V v, boolean isDirected) {
			this.element = v;
			this.outgoing = new LinkedPositionalList<>();
			if(!isDirected)
				this.incoming = this.outgoing;
			else
				this.incoming = new LinkedPositionalList<>();
		}
		
		@Override
		public boolean validate(Graph<V, ?> graph) {
			return (AdjacencyListGraph.this == graph && position != null);
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
		
		public PositionalList<Edge<E>> getIncomingEdges() {return incoming;}
		
		public PositionalList<Edge<E>> getOutgoingEdges() {return outgoing;}
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
			return (AdjacencyListGraph.this == graph && position != null);
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
	public Edge<E> getEdge(Vertex<V> v, Vertex<V> w) throws IllegalArgumentException {
		InnerVertex<V> v1 = validate(v), v2 = validate(w);
		
		for (Edge<E> e : v1.getOutgoingEdges()) {
			InnerEdge<E> edge = validate(e);
			Vertex<V>[] vertex = endVertices(edge);
			if(vertex[1] == v2 && this.isDirected) 
				return edge;
			if((vertex[1] == v2 || vertex[0] == v2) && !this.isDirected) 
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
		InnerVertex<V> vertex = validate(v);
		return vertex.getOutgoingEdges().size();
	}

	@Override
	public int inDegree(Vertex<V> v) {
		if(!this.isDirected)
			return this.outDegree(v);
		else {
			InnerVertex<V> vertex = validate(v);
			return vertex.getIncomingEdges().size();
		}	
	}

	@Override
	public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) {
		InnerVertex<V> vertex = validate(v);
		return vertex.getIncomingEdges();
	}

	@Override
	public Iterable<Edge<E>> incomingEdges(Vertex<V> v) {
		if(!this.isDirected)
			return this.outgoingEdges(v);
		else {
			InnerVertex<V> vertex = validate(v);
			return vertex.getIncomingEdges();
		}
	}

	@Override
	public Vertex<V> insertVertex(V x) {
		InnerVertex<V> newVertex = new InnerVertex<>(x, this.isDirected); 
		newVertex.setPosition(this.vertexList.addLast(newVertex));
		return newVertex;
	}
	
	//Link two vertex that exists in the graph.
	@Override
	public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E e) throws IllegalArgumentException {
		if(this.getEdge(u, v) == null) {
			InnerVertex<V> orign = validate(u), dest = validate(v);
			InnerEdge<E> newEdge = new InnerEdge<>(orign ,dest ,e);
			newEdge.setPosition(this.edgeList.addLast(newEdge));
			orign.getOutgoingEdges().addLast(newEdge);
			if(orign != dest) dest.getIncomingEdges().addLast(newEdge);
			return newEdge;
		} else
			throw new IllegalArgumentException("Edge from u to v exists.");
	}

	@Override
	public void removeVertex(Vertex<V> v) {
		
	}

	@Override
	public void removeEdge(Edge<E> e) {
		InnerEdge<E> edge = validate(e);
		InnerVertex<V> v0 = validate(edge.endPoints[0]), v1 = validate(edge.endPoints[1]);
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Vertex<V> v : vertices()) {
		      sb.append("Vertex " + v.getElement() + "\n");
		      if (isDirected)
		        sb.append(" [outgoing]");
		      sb.append(" " + outDegree(v) + " adjacencies:");
		      for (Edge<E> e: outgoingEdges(v))
		        sb.append(String.format(" (%s, %s)", opposite(v,e).getElement(), e.getElement()));
		      sb.append("\n");
		      if (isDirected) {
		        sb.append(" [incoming]");
		        sb.append(" " + inDegree(v) + " adjacencies:");
		        for (Edge<E> e: incomingEdges(v))
		          sb.append(String.format(" (%s, %s)", opposite(v,e).getElement(), e.getElement()));
		        sb.append("\n");
		      }
		    }
		return sb.toString();
	}
}