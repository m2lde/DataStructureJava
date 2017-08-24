package datastructure.graph;

public interface Graph<V, E> {
	
	/**
	 * @return the number of vertices of the graph.
	 */
	public int numVertices();

	/**
	 * @return the number of edges of the graph.
	 */
	public int numEdges();
	
	/**
	 * @return an iteration of all vertices of the graph.
	 */
	public Iterable<Vertex<V>> vertices();

	/**
	 * @return an iteration of all edges of the graph.
	 */
	public Iterable<Edge<E>> edges();

	/**
	 * @param v
	 * @param w
	 * @return the edge from vertex v to vertex w, if exists;
	 * 		   otherwise return null.For an undirected graph, there is no
	 *		   difference between getEdge(u, v) and getEdge(v, u).
	 */
	public Edge<E> getEdge(Vertex<V> v, Vertex<V> w);

	/**
	 * @param e
	 * @return 	an array containing the two endpoint vertices of
	 *			edge e. If the graph is directed, the first vertex is the origin
	 *			and the second is the destination.
	 */
	public Vertex<V>[] endVertices(Edge<E> e);
	
	/**
	 * @param v
	 * @param e
	 * @return For edge e incident to vertex v, returns the other vertex of
	 *	the edge; an error occurs if e is not incident to v.
	 */
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException;

	/**
	 * @param v
	 * @return the number of outgoing edges from vertex v.
	 */
	public int outDegree(Vertex<V> v) throws IllegalArgumentException;

	/**
	 * @param v
	 * @return the number of incoming edges to vertex v. For
	 *	an undirected graph, this returns the same value as does
	 *	outDegree(v).
	 */
	public int inDegree(Vertex<V> v);

	/**
	 * @param v
	 * @return an iteration of all outgoing edges from vertex v.
	 */
	public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) throws IllegalArgumentException;
	
	/**
	 * @param v
	 * @return an iteration of all incoming edges to vertex v. For
	 *	an undirected graph, this returns the same collection as
	 *	does outgoingEdges(v).
	 */
	public Iterable<Edge<E>> incomingEdges(Vertex<V> v) throws IllegalArgumentException;
	
	/**
	 * @param e
	 * @return Creates and returns a new Vertex storing element x.
	 */
	public Vertex<V> insertVertex(V x);
	
	/** 
	 * @param u
	 * @param v
	 * @param e
	 * @return Creates and returns a new Edge from vertex u to vertex v,
	 *	storing element x; an error occurs if there already exists an
	 *	edge from u to v.
	 * @throws Exception
	 */
	public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E e) throws IllegalArgumentException;
	
	/**
	 * Removes vertex v and all its incident edges from the graph.
	 * @param v
	 */
	public void removeVertex(Vertex<V> v) throws IllegalArgumentException;
	
	/**
	 * Removes edge e from the graph.
	 * @param e
	 */
	public void removeEdge(Edge<E> e) throws IllegalArgumentException;
}
