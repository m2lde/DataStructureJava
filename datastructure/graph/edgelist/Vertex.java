package datastructure.graph.edgelist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class Vertex<V, E> {
	private V element;
	private List<Edge<E, V>> incident = new LinkedList<>();
	
	public Vertex(V o) {this.element = o;}
	
	public boolean isAlone() {return this.incident.isEmpty();}
	
	public Iterator<Edge<E, V>> incidentList() {return this.incidentList();}
	
	public V getElement() {return element;}
	
	public void setElement(V element) {this.element = element;}
	
	public void addIncidentEdge(Edge<E, V> e) {this.incident.add(e);}
}
