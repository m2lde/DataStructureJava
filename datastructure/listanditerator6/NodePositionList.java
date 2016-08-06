package datastructure.listanditerator6;

import datastructure.exceptions.EmptyListException;
import datastructure.exceptions.BoundaryViolationException;
import datastructure.exceptions.InvalidPositionException;
import java.util.Iterator;

/**
 *
 * @author mrl00
 * @param <E>
 */
public class NodePositionList<E> implements PositionList<E>{
    protected int numElem;
    protected DNode<E> header, trailer;

    public NodePositionList() {
        this.numElem = 0;
        this.header = new DNode<>();
        this.trailer = new DNode<>(this.header, null, null);
        this.header.setNext(this.trailer);
    }
    
    public DNode<E> checkPosition(Position<E> p) 
            throws InvalidPositionException {
        if(p == null)
            throw new InvalidPositionException("Null position passed to Nodelist");
        if(p == this.trailer || p == this.header)
            throw new InvalidPositionException("Header|Trailer position is not valid");
        try {
            DNode<E> temp = (DNode<E>) p;
            if(temp.getNext() == null || temp.getPrev() == null)
                throw new InvalidPositionException("Position does not belong to a valid NodeList");
            return temp;
        } catch (ClassCastException e) {
            throw new InvalidPositionException("Position is of wrong type for this list");
        }
    }
    
    @Override
    public int size() {return this.numElem;}

    @Override
    public boolean isEmpty() {return this.numElem == 0;}

    @Override
    public Position<E> first() throws EmptyListException {
        if(isEmpty())
            throw new EmptyListException("A lista esta vazia.");
        return this.header.getNext();
    }

    @Override
    public Position<E> last() throws EmptyListException{
        if(isEmpty())
            throw new EmptyListException("A lista esta vazia.");
        return this.trailer.getPrev();
    }

    @Override
    public Position<E> next(Position<E> p) 
            throws InvalidPositionException, BoundaryViolationException {
        DNode<E> v = checkPosition(p);
        if(v.getNext() == this.trailer)
                throw new InvalidPositionException("Cannot advance past the begging of the list.");
        return v.getNext();
    }

    @Override
    public Position<E> prev(Position<E> p) 
            throws InvalidPositionException, BoundaryViolationException {
        DNode<E> v = checkPosition(p);
        if(v.getPrev() == this.header)
                throw new InvalidPositionException("Cannot advance past the begging of the list.");
        return v.getPrev();
    }

    @Override
    public void addFirst(E e) {
        DNode<E> newNode = new DNode<>(header, header.getNext(), e);
        this.header.getNext().setPrev(newNode);
        this.header.setNext(newNode);
    }

    @Override
    public void addLast(E e) {
        DNode<E> newNode = new DNode<>(this.trailer.getPrev(), this.trailer, e);
        this.trailer.getPrev().setNext(newNode);
        this.trailer.setPrev(newNode);
    }

    @Override
    public void addAfter(Position<E> p, E e) throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        this.numElem++;
        DNode<E> newNode = new DNode<>(v, v.getNext(), e);
        v.getNext().setPrev(newNode);
        v.setNext(newNode);
    }

    @Override
    public void addBefore(Position<E> p, E e) 
            throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        this.numElem++;
        DNode<E> newNode = new DNode<>(v.getPrev(), v, e);
        v.getPrev().setNext(newNode);
        v.setPrev(newNode);
    }

    @Override
    public E remove(Position<E> p) throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        this.numElem--;
        v.getPrev().setNext(v.getNext());
        v.getNext().setPrev(v.getPrev());
        E vElem = v.element();
        v.setNext(null);
        v.setPrev(null);
        return vElem;
    }

    @Override
    public E set(Position<E> p, E e) throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        E oldElem = v.element();
        v.setElement(e);
        return oldElem;
    }

    @Override
    public Iterator<E> iterator() {return new ElementIterator<>(this);}
    
    public static <E> String toString(PositionList<E> l){
        Iterator<E> it = l.iterator();
        String s = "[";
        while(it.hasNext()) {
            s += it.next();
            if(it.hasNext()) {
                s += ", ";
            }
        }
            
        return s + "]";
    }

    @Override
    public Iterable<Position<E>> positions() {
        PositionList<Position<E>> P = new NodePositionList<>();
        if(!isEmpty()) {
            Position<E> p = first();
            while(true){
                P.addLast(p);
                if(p == last())
                    break;
                p = next(p);
            }
        }
        return P; 
    }
}
