package datastructure.graph;

import datastructure.lists.Position;

public interface Edge<E> extends Position<E>, Cloneable {
	
	public boolean validate(Graph<?, E> graph);
		
	public Vertex<?>[] getEndPoints();
	
	public Position<Edge<E>> getPosition();
	
	public void setPosition(Position<Edge<E>> p);
}
