package datastructure.graph;

import datastructure.lists.Position;

public interface Edge<E> extends Position<E>{
	
	public boolean validate(Graph<?, E> graph);
	
	public boolean isDirected();
	
	public Vertex<?>[] endPoints();
	
	public Position<Edge<E>> getPosition();
	
	public void setPosition(Position<Edge<E>> p);
}
