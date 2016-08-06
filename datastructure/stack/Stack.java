
package datastructure.stack;

import datastructure.exceptions.EmptyStackException;

/**
 *
 * @author mrl00
 * @param <E>
 */
public interface Stack<E> {
    
    /**
     * Retorna o numero de elementos da pilha
     * @return numero de elementos da pilha 
     */
    public int size();
    
    /**
     * indica quando a pilha esta vazia.
     * @return true se a pilha esta vazia. 
     */
    public boolean isEmpty();
    
    /**
     * Inspeciona o elemento no topo da pilha.
     * @return o elemento no topo da pilha.
     * @throws EmptyStackException 
     */
    public E top()
            throws EmptyStackException;
    
    /**
     * Insere um elemento na pilha
     * @param elemento a ser inserido 
     */ 
    public void push (E elemento);
    
    /**
     * Remove o elemto no topo da pilha
     * @return elemento a ser removido.
     * @throws EmptyStackException 
     */
    public E pop()
            throws EmptyStackException;
}
