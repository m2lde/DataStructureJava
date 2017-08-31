package datastructure.lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayList<E> implements IndexList<E>{
	public static final int INITIAL_CAPACITY = 20;
	private E[] data;
	private int size = 0;
	
	//Iterator
	private class ArrayIterator implements Iterator<E> {
		private int j = 0;
		
		@Override
		public boolean hasNext() {return j < size;}

		@Override
		public E next() throws NoSuchElementException {
			if(j == size) 
				throw new NoSuchElementException("No next element.");
			return data[j++];
		}
	}
	
	//Constructors
	public ArrayList() {this(INITIAL_CAPACITY);}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {this.data = (E[]) new Object[capacity];}
	
	//Utilities
	private void checkIndex(int index, int size) throws IndexOutOfBoundsException {
		if(index >= size || index < 0)
			throw new IndexOutOfBoundsException("Illegal index: " + index);
	}
	
	private void resize(int capacity) {
		this.data = Arrays.copyOf(this.data, capacity);
	}
	
	@Override
	public int size() {return this.size;}

	@Override
	public boolean isEmpty() {return this.size == 0;}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		checkIndex(index, this.size);
		return this.data[index];
	}
	/**
	 * Replaces the element at index i with e, and returns the replaced element.
	 */
	@Override
	public E set(int index, E element) throws IndexOutOfBoundsException {
		checkIndex(index, this.size);
		E tmp = data[index];
		data[index] = element;
		return tmp;
	}

	@Override
	public void add(int index, E element) throws IndexOutOfBoundsException {
		checkIndex(index, this.size + 1);
		if(size == data.length)
			resize(ArrayList.INITIAL_CAPACITY + this.data.length);
		for (int i = this.size - 1; i >= index; i--)
			this.data[i + 1] = this.data[i];
		data[index] = element; this.size++;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		checkIndex(index, this.size);
		E tmp = this.data[index];
		for (int i = index; i < this.size - 1; i++)
			this.data[i] = this.data[i + 1];
		data[this.size - 1] = null; this.size--;
		return tmp;
	}

	@Override
	public Iterator<E> iterator() {return new ArrayIterator();}

}
