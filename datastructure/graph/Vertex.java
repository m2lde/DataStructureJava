package datastructure.graph;

import datastructure.listanditerator.Position;

public interface Vertex<V> extends Position<V>{
	
	public boolean validate(Graph<V, ?> graph);

	public void setElement(V v);

	public Position<Vertex<V>> getPosition();
	
	public void setPosition(Position<Vertex<V>> pos);
}
