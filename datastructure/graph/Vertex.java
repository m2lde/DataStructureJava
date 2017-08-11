package datastructure.graph;

import datastructure.exceptions.InvalidPositionException;

public class Vertex<E> implements Position<E>{
	private String label;
	private E element;
	
	public Vertex(String label) {
		this.label = label;
		this.element = null;
	}
	
	public Vertex(String label, E element) {
		this.label = label;
		this.element = element;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public E element() {
		if(this.element == null)
			throw new InvalidPositionException("Invalid Position.");
		return this.element;
	}
}
