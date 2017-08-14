package datastructure.graph.edgelist;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class Edge<E, V>{
	private E element;
	private Vertex<V, E> v, w;
	
	public Edge(E element, Vertex<V, E> v, Vertex<V, E> w) {

		this.element = element;
		this.v = v;
		this.w = w;
	}



	public void setElement(E element) {
		this.element = element;
	}
}
