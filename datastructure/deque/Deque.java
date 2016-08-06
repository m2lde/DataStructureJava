/**
 * Interface para um deque: uma coleção de objetos que são inseridos e removidos em
 * ambas as extremidades; um subconjunto dos mértodos de Java.util.LinkedList
 */
package datastructure.deque;

import datastructure.exceptions.EmptyDequeException;
/**
 *
 * @author mrl00
 */
public interface Deque<E> {
    
    /**
     * Retorna o numero de elementos no deque.
     * @return 
     */
    public int size();
    
    /**
     * Retorna se o deque está vazio.
     * @return 
     */
    public boolean isEmpty();
    
    /**
     * Retorna o primeiro elemento de deque;
     * Uma exceção e lançada se o deque está vazio.
     * @return
     * @throws EmptyDequeException 
     */
    public E getFirst() 
            throws EmptyDequeException;
    
    /**
     * Retorna o ultimo elemento de deque;
     * Uma exceção e lançada se o deque está vazio.
     * @return
     * @throws EmptyDequeException 
     */
    public E getLast() 
            throws EmptyDequeException;
    
    /**
     * Insere um elemento para ser o primeiro de deque.
     * @param element 
     */
    public void addFirst(E element);
    
    /**
     * Insere um elemento para ser o ultimo de deque.
     * @param element 
     */
    public void addLast(E element);
    
    /**
     * Remove o primeiro elemento;
     * uma exceção é lançada se o deque está vazio.
     * @return
     * @throws EmptyDequeException 
     */
    public E removeFirst() 
            throws EmptyDequeException;
    
    /**
     * Remove o ultimo elemento;
     * uma exceção é lançada se o deque está vazio.
     * @return
     * @throws EmptyDequeException 
     */
    public E removeLast() 
            throws EmptyDequeException;
}
