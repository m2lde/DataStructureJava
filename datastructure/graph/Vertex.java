package datastructure.graph;

import datastructure.lists.Position;

public interface Vertex<V> extends Position<V>{
	
	boolean validate(Graph<V, ?> graph);

	void setElement(V v);

	Position<Vertex<V>> getPosition();
	
	void setPosition(Position<Vertex<V>> pos);
	
	
}
