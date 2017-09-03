package datastructure.lists;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedPositionalList<E> implements PositionalList<E>{
	
	//Private Classes
	private static class Node<E> implements Position<E> {
		private E element;
		private Node<E> prev, next;
		
		
		public Node(E element, Node<E> prev, Node<E> next) {
			super();
			this.element = element;
			this.prev = prev;
			this.next = next;
		}

		@Override
		public E getElement() throws IllegalStateException {
			if(this.next == null)
				throw new IllegalStateException("Position no longer valid.");
			return this.element;
		}

		public Node<E> getNext() {return this.next;}

		public void setNext(Node<E> next) {this.next = next;}

		public Node<E> getPrev() {return this.prev;}

		public void setPrev(Node<E> prev) {this.prev = prev;}
		
		public void setElement(E element) {this.element = element;}
		
	}
	
	private class PositionIterator implements Iterator<Position<E>> {
		private Position<E> cursor = first(), recent = null;
		
		@Override
		public boolean hasNext() {return (cursor != null);}

		@Override
		public Position<E> next() throws NoSuchElementException {
			if(cursor == null) 
				throw new NoSuchElementException("Nothing left");
			
			recent = cursor; cursor = after(cursor);
			
			return recent;
		}
		
		@Override
		public void remove() throws IllegalStateException{
			if(recent == null) 
				throw new IllegalStateException("Nothing to remove.");
			LinkedPositionalList.this.remove(recent);
			recent = null;
		}
		
	}
	
	private class PositionIterable implements Iterable<Position<E>> {
		@Override
		public Iterator<Position<E>> iterator() {return new PositionIterator();}
	}
	
	@SuppressWarnings("unused")
	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> posIterator = new PositionIterator();
		
		@Override
		public boolean hasNext() {return posIterator.hasNext();}

		@Override
		public E next() {return posIterator.next().getElement();}
		
		@Override
		public void remove() {posIterator.remove();}
	}
	
	private Node<E> header, trailer;
	private int size = 0;
	
	public LinkedPositionalList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	//Private utilities.
	
	/**
	 * 
	 * @param p
	 * @return node. Validate this position and return it as node.
	 * @throws IllegalArgumentException
	 */
	
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if(!(p instanceof Node)) 
			throw new IllegalArgumentException("Invalid position.");
		
		Node<E> node = (Node<E>) p;
		
		if(node.getNext() == null)
			throw new IllegalArgumentException("Position is no longer in the list.");
		return node;
	}
	
	private Position<E> position(Node<E> node) {
		if(node == this.header || node == this.trailer)
			return null;
		return node;
	}
	
	private Position<E> addBetween(E element, Node<E> pred, Node<E> succ){
		Node<E> newNode = new Node<>(element, pred, succ);
		pred.setNext(newNode);
		succ.setPrev(newNode);
		this.size++;
		return newNode;
	}
	
	
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	@Override
	public int size() {return this.size;}

	@Override
	public boolean isEmpty() {return this.size == 0;}

	@Override
	public Position<E> first() {
		return position(header.getNext());
	}

	@Override
	public Position<E> last() {
		return position(trailer.getPrev());
	}
	@Override
	public E get(Position<E> p) {
		return position(validate(p)).getElement();
	}
	
	/**
	 * @return the position imediatly after position p (or null if p is the first). 
	 */
	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		return position(validate(p).getNext());
	}
	
	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.prev);
	}

	@Override
	public Position<E> addFirst(E e) {
		return addBetween(e, this.header, this.header.next);
	}

	@Override
	public Position<E> addLast(E e) {
		return addBetween(e, this.trailer.prev, this.trailer);
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node.getNext(), node);
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node 		= validate(p),
				predecessor	= node.getPrev(),
				successor	= node.getNext();
		
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		this.size--;
		E answer = node.getElement();
		node.setNext(null); node.setElement(null); node.setPrev(null);
		return answer;
	}

	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}

	@Override
	public Iterable<Position<E>> positions() {return new PositionIterable();}

}
