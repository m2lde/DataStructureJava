package datastructure.listanditerator6;

import datastructure.exceptions.EmptyListException;
import datastructure.exceptions.BoundaryViolationException;
import datastructure.exceptions.InvalidPositionException;

/**
 * @author mrl00
 * @param <E>
 */
public interface PositionList<E> extends Iterable<E>{
    /**
     * 
     * @return numero de elementos da lista
     */
    public int size();
    
    /**
     * 
     * @return quando a lista esta vazia
     */
    public boolean isEmpty();
    /**
     * 
     * @return Retona o primeiro nodo da lista 
     */
    public Position<E> first() throws EmptyListException;
    
    /**
     * 
     * @return Retorna o ultimo nodo da lista
     */
    public Position<E> last() throws EmptyListException;
    
    /**
     * 
     * @param p
     * @return um nodo que segue um determinado nodo da lista,
     * retorna um erro se for o ultimo da lista
     * @throws InvalidPositionException
     * @throws BoundaryViolationException 
     */
    public Position<E> next(Position<E> p)
            throws InvalidPositionException, BoundaryViolationException;
    
    /**
     * @param p
     * @return um nodo que antecede um determinado nodo da lista,
     * retorna um erro se for o primeiro da lista.
     * @throws InvalidPositionException
     * @throws BoundaryViolationException 
     */
    public Position<E> prev(Position<E> p)
            throws InvalidPositionException, BoundaryViolationException;
    
    /**
     * Adiciona um elemento e no inicio da lista.
     * 
     * @param e 
     */
    public void addFirst(E e);
    
    /**
     * Adiciona um elemento "e" no fim da lista.
     * 
     * @param e
     */
    public void addLast(E e);
    
    /**
     * Adiciona um elemento e depois de uma posicao p.
     * 
     * @param p
     * @param e 
     */
    public void addAfter(Position<E> p, E e);
    
    /**
     * Adiciona um elemento e antes da posicao p.
     * 
     * @param p
     * @param e 
     */
    public void addBefore(Position<E> p, E e);
    
    /**
     * Remove um nodo p retornando o elemento que la estava.
     * 
     * @param p
     * @return
     * @throws InvalidPositionException 
     */
    public E remove(Position<E> p)
            throws InvalidPositionException;
    
    /**
     * Substitui um elemento armazenado em um determinado nodo,
     * retornando o elemento que la estava.
     * 
     * @param p
     * @param e
     * @return
     * @throws InvalidPositionException 
     */
    public E set(Position<E> p, E e)
            throws InvalidPositionException;
    
    public Iterable<Position<E>> positions();
    
}
