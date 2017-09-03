package datastructure.lists;

/**
 * @author mrl00
 * @param <E>
 */
public interface PositionalList<E> extends Iterable<E>, Cloneable {
    /**
     * 
     * @return number of elements in the list.
     */
    public int size();
    
    /**
     * 
     * @return when the list is empty.
     */
    boolean isEmpty();
    /**
     * 
     * @return the first element of list. 
     */
    Position<E> first();
    
    /**
     * @return the last element of list.
     */
    Position<E> last();
    
    /**
     * @param p
     * @return
     */
    E get(Position<E> p);
    
    /**
     * 
     * @param p
     * @return a node that follow a determined node of list,
     * return an error if that node is last of list.
     */
    Position<E> after(Position<E> p)
    		throws IllegalArgumentException;
    
    /**
     * @param p
     * @return um nodo que antecede um determinado nodo da lista,
     * retorna um erro se for o primeiro da lista.
     * @throws InvalidPositionException
     * @throws BoundaryViolationException 
     */
    Position<E> before(Position<E> p)
            throws IllegalArgumentException;
    
    /**
     * Add a element in begin of list.
     * @param e 
     */
    Position<E> addFirst(E e);
    
    /**
     * Adiciona um elemento "e" no fim da lista.
     * 
     * @param e
     */
    Position<E> addLast(E e);
    
    /**
     * Adiciona um elemento e depois de uma posicao p.
     * 
     * @param p
     * @param e 
     */
    Position<E> addAfter(Position<E> p, E e)
    		throws IllegalArgumentException;
    
    /**
     * Adiciona um elemento e antes da posicao p.
     * 
     * @param p
     * @param e 
     */
    Position<E> addBefore(Position<E> p, E e)
    		throws IllegalArgumentException;
    
    /**
     * Remove um nodo p retornando o elemento que la estava.
     * 
     * @param p
     * @return
     * @throws InvalidPositionException 
     */
    E remove(Position<E> p)
            throws IllegalArgumentException;
    
    /**
     * Substitui um elemento armazenado em um determinado nodo,
     * retornando o elemento que la estava.
     * 
     * @param p
     * @param e
     * @return
     * @throws InvalidPositionException 
     */
    E set(Position<E> p, E e)
            throws IllegalArgumentException;
    
    Iterable<Position<E>> positions();
    
}
