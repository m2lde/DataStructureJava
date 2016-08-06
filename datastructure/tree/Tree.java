
package datastructure.tree;

import datastructure.exceptions.BoundaryViolationException;
import datastructure.exceptions.InvalidPositionException;
import datastructure.exceptions.EmptyTreeException;
import java.util.Iterator;

/**
 * Interface para uma arvore onde os nodos podem ter
 * uma quantidade arbitrária de filhos.
 * 
 * @author mrl00
 * @param <E>
 */
public interface Tree<E> {

    /**
     * Retorna a quantidade de nodos da arvore.
     * @return 
     */
    public int size();
    
    /**
     * Retorna se a arvore esta vazia.
     * @return 
     */
    public boolean isEmpty();
    
    /**
     * Retorna um iterador sobre os elementos armazenados na arvore.
     * @return 
     */
    public Iterator<E> iterator();
    
    /**
     * Retorna uma coleção iterável dos nodos.
     * @return 
     */
    public Iterable<Position<E>> positions();
    
    /**
     * Substitui o elemento armazenado em um dado nodo.
     * @param v
     * @param e
     * @return
     * @throws InvalidPositionException 
     */
    public E replace(Position<E> v, E e)
            throws InvalidPositionException;
    

    /**
     * Retorna a raiz da arvore.
     * @return 
     */
    public Position<E> root() 
            throws EmptyTreeException;

    /**
     * Retorna o pai de um nodo.
     * @param v
     * @return
     * @throws InvalidPositionException
     * @throws BoundaryViolationException 
     */
    public Position<E> parent(Position<E> v)
            throws InvalidPositionException, BoundaryViolationException;
    
    /**
     * Retorna uma colecao iterável
     * dos filhos de um dado nodo.
     * @param v
     * @return
     * @throws InvalidPositionException 
     */
    public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException;
    

    /**
     * Retorna se um dado nodo e interno.
     * @param v
     * @return
     * @throws InvalidPositionException 
     */
    public boolean isInternal(Position<E> v) throws InvalidPositionException;
    
    /**
     * 
     * @param v
     * @return
     * @throws InvalidPositionException 
     */
    public boolean isExternal(Position<E> v) throws InvalidPositionException;
    
    /**
     * 
     * @param v
     * @return
     * @throws InvalidPositionException 
     */
    public boolean isRoot(Position<E> v) throws InvalidPositionException;
}
