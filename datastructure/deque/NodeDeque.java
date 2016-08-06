package datastructure.deque;

import datastructure.node.DLNode;
import datastructure.exceptions.EmptyDequeException;

/**
 * 
 * @author mrl00
 */
public class NodeDeque<E> implements Deque<E>{
    protected DLNode<E> header, trailer;    //sentinelas
    protected int size;
    //numero de elementos
    public NodeDeque() {                    //inicializa um deque vazio
        header = new DLNode<>();
        trailer = new DLNode<>();
        header.setNext(trailer);            //faz a cabeça apontar para a cauda
        trailer.setPrev(header);            //faz a cauda apontar para a cabeça
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public E getLast() throws EmptyDequeException {
        if(isEmpty())
            throw new EmptyDequeException("Deque is empty");
        return trailer.getPrev().getElement();
    }
    
    @Override
    public E getFirst() throws EmptyDequeException {
        if(isEmpty())
            throw new EmptyDequeException("Deque is empty");
        return header.getNext().getElement();
    }

    @Override
    public void addFirst(E o) {
        DLNode<E> second = header.getNext();
        DLNode<E> first = new DLNode<>(o, header, second);
        second.setPrev(first);
        header.setNext(first);
        size++;
    }

    @Override
    public void addLast(E o) {
        DLNode<E> secondtolast = trailer.getPrev();
        DLNode<E> last = new DLNode<>(o, secondtolast, trailer);
        secondtolast.setNext(last);
        trailer.setPrev(last);
        size++;
    }

    @Override
    public E removeFirst() throws EmptyDequeException {
        if(isEmpty())
            throw new EmptyDequeException("Deque is empty");
        DLNode<E> first = header.getNext();
        E o = first.getElement();
        DLNode<E> second = first.getNext();
        header.setNext(second);
        second.setPrev(header);
        size--;
        return o;
    }

    @Override
    public E removeLast() throws EmptyDequeException {
        if(isEmpty())
            throw new EmptyDequeException("Deque is empty");
        DLNode<E> last = trailer.getPrev();
        E o = last.getElement();
        DLNode<E> secondtolast = last.getPrev();
        trailer.setPrev(secondtolast);
        secondtolast.setNext(trailer);
        size--;
        return o;
    }
}
