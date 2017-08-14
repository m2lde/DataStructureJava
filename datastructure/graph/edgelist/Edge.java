package datastructure.graph.edgelist;

@SuppressWarnings("unused")
public class Edge<E, V>{
	private E element;
	private Vertex<V, E>[] vertices;
	
	@SuppressWarnings("unchecked")
	public Edge(E element, Vertex<V, E> v, Vertex<V, E> w) {
		this.element = element;
		this.vertices = (Vertex<V, E>[]) new Vertex[]{v,w};
	}
	
	public Vertex<V, E>[] getVertices() {return this.vertices;}

	public void setElement(E element) {this.element = element;}
}
