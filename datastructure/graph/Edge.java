package datastructure.graph;

import datastructure.exceptions.InvalidPositionException;

public class Edge<E> implements Position<E>{
	private Vertex<?> begin, end;
	private E element;
	private int weight;
	
	public Edge() {
		this.begin = this.end = null;
		this.element = null;
		this.weight = 0;
	}
	
	public Edge(Vertex<?> begin, Vertex<?> end, E element, int weight) {
		this.begin = begin;
		this.end = end;
		this.element = element;
		this.weight = weight;
	}
	
	public Edge(Vertex<?> begin, Vertex<?> end) {
		this.begin = begin;
		this.end = end;
		this.element = null;
		this.weight = 0;
	}

	public int getWeight() {
		return weight;
	}
	
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public E element() {
		if(this.element == null)
			throw new InvalidPositionException("Invalid Position.");
		return this.element;
	}
}
