package datastructure.graph;

import datastructure.lists.LinkedPositionalList;
import datastructure.lists.Position;
import datastructure.lists.PositionalList;

public class AdjacencyMatrixGraph<V,E> implements Graph<V, E> {
	private boolean isDirected;
	private PositionalList<Vertex<V>> vertexList;
	private PositionalList<Edge<E>> edgeList;
	private Edge<E> adjacencyMatrix[][];
	
	private class InnerVertex<V> implements Vertex<V>{
		private V element;
		private Position<Vertex<V>> position;
		private int index;
		
		
		InnerVertex(V element) {
			super();
			this.element = element;
		}
		
		public boolean validate(Graph<V,E> graph) {return AdjacencyMatrixGraph.this == graph;}

		@Override
		public V getElement() {return this.element;}
		
		void setElement(V element) {this.element = element;}

		int getIndex() {return this.index;}
		
		void setIndex(int index) {this.index = index;}
		
		Position<Vertex<V>> getPosition() {return this.position;}
	}
	
	private class InnerEdge<E> implements Edge<E> {
		private E element;
		private Vertex<V>[] endPoints = new Vertex[2];
		
		
		public boolean validate(Graph<V,E> graph) {return AdjacencyMatrixGraph.this == graph;}
		
		@Override
		public E getElement() throws IllegalStateException {return this.element;}
		
		void setElement(E element) {this.element = element;}
		
		Vertex<V>[] getEndPoints() {return this.endPoints;}
	}
	
	private InnerVertex<V> validate(Vertex<V> v) {
		    if (!(v instanceof InnerVertex)) throw new IllegalArgumentException("Invalid vertex");
		    InnerVertex<V> vert = (InnerVertex<V>) v;     // safe cast
		    if (!vert.validate(this)) throw new IllegalArgumentException("Invalid vertex");
		    return vert;
	 }

	 private InnerEdge<E> validate(Edge<E> e) {
		    if (!(e instanceof InnerEdge)) throw new IllegalArgumentException("Invalid edge");
		    InnerEdge<E> edge = (InnerEdge<E>) e;     // safe cast
		    if (!edge.validate(this)) throw new IllegalArgumentException("Invalid edge");
		    return edge;
		  }
	
	public AdjacencyMatrixGraph(boolean isDirected) {
		super();
		this.isDirected = isDirected;
		this.vertexList = new LinkedPositionalList<>();
		this.edgeList = new LinkedPositionalList<>();
	}

	@Override
	public int numVertices() {
		return this.vertexList.size();
	}

	@Override
	public int numEdges() {
		return this.edgeList.size();
	}

	@Override
	public Iterable<Vertex<V>> vertices() {
		return this.vertexList;
	}

	@Override
	public Iterable<Edge<E>> edges() {
		return this.edgeList;
	}

	@Override
	public Edge<E> getEdge(Vertex<V> v, Vertex<V> w) {
		InnerVertex<V> v1 = validate(v), v2 = validate(w);
		return this.adjacencyMatrix[v1.getIndex()][v2.getIndex()];
	}

	@Override
	public Vertex<V>[] endVertices(Edge<E> e) {
		return validate(e).getEndPoints();
	}

	@Override
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException {
		Vertex<V>[] verts = this.endVertices(e);
		if(verts[0] == v) 
			return verts[1];
		else if(verts[1] == v) 
			return verts[0];
		else
			throw new IllegalArgumentException("These vertices are not incidents.");
	}

	@Override
	public int outDegree(Vertex<V> v) throws IllegalArgumentException {
		int count = 0; InnerVertex<V> vertex = validate(v);
		for (int i = 0; i < this.adjacencyMatrix.length; i++) {
			InnerEdge<E> edge = validate(this.adjacencyMatrix[vertex.getIndex()][i]); 
			if(edge != null && edge.getEndPoints()[0] == v && this.isDirected) count++;
			if(edge != null && (edge.getEndPoints()[0] == v || edge.getEndPoints()[1] == v) && !this.isDirected) count++;
		}
		return count;
	}

	@Override
	public int inDegree(Vertex<V> v) {
		if(this.isDirected)
			return this.outDegree(v);
		else {
			int count = 0; InnerVertex<V> vertex = validate(v);
			for (int i = 0; i < this.adjacencyMatrix.length; i++) {
				InnerEdge<E> edge = validate(this.adjacencyMatrix[vertex.getIndex()][i]); 
				if(edge != null && edge.getEndPoints()[1] == v) count++;
			}

			return count;
		}
	}

	@Override
	public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) throws IllegalArgumentException {
		return null;
	}

	@Override
	public Iterable<Edge<E>> incomingEdges(Vertex<V> v) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex<V> insertVertex(V x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeVertex(Vertex<V> v) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEdge(Edge<E> e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

}
