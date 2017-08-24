package datastructure.listanditerator;

import datastructure.exceptions.InvalidPositionException;

/**
 *
 * @author mrl00
 * @param <E>
 */
public class DNode<E> implements Position<E>{
    private DNode<E> prev, next;
    private E element;

    public DNode() {
        this(null, null, null);
    }
    
    public DNode(DNode<E> prev, DNode<E> next, E element) {
        this.prev = prev;
        this.next = next;
        this.element = element;
    }

    public DNode<E> getPrev() {return prev;}
    
    public DNode<E> getNext() {return next;}

    public void setPrev(DNode<E> prev) {this.prev = prev;}

    public void setNext(DNode<E> next) {this.next = next;}

    public void setElement(E element) {this.element = element;}

    @Override
    public E getElement() 
            throws InvalidPositionException {
        if((this.prev == null) && (this.next == null))
            throw new InvalidPositionException("Posicao invalida");
        return this.element;
    }
    
}
