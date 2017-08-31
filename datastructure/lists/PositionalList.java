package datastructure.listanditerator;

/**
 * @author mrl00
 * @param <E>
 */
public interface PositionList<E> extends Iterable<E>{
    /**
     * 
     * @return number of elements in the list.
     */
    public int size();
    
    /**
     * 
     * @return when the list is empty.
     */
    public boolean isEmpty();
    /**
     * 
     * @return the first element of list. 
     */
    public Position<E> first();
    
    /**
     * 
     * @return the last element of list.
     */
    public Position<E> last();
    
    /**
     * 
     * @param p
     * @return a node that follow a determined node of list,
     * return an error if that node is last of list.
     */
    public Position<E> after(Position<E> p)
    		throws IllegalArgumentException;
    
    /**
     * @param p
     * @return um nodo que antecede um determinado nodo da lista,
     * retorna um erro se for o primeiro da lista.
     * @throws InvalidPositionException
     * @throws BoundaryViolationException 
     */
    public Position<E> before(Position<E> p)
            throws IllegalArgumentException;
    
    /**
     * Add a element in begin of list.
     * @param e 
     */
    public Position<E> addFirst(E e);
    
    /**
     * Adiciona um elemento "e" no fim da lista.
     * 
     * @param e
     */
    public Position<E> addLast(E e);
    
    /**
     * Adiciona um elemento e depois de uma posicao p.
     * 
     * @param p
     * @param e 
     */
    public Position<E> addAfter(Position<E> p, E e)
    		throws IllegalArgumentException;
    
    /**
     * Adiciona um elemento e antes da posicao p.
     * 
     * @param p
     * @param e 
     */
    public Position<E> addBefore(Position<E> p, E e)
    		throws IllegalArgumentException;
    
    /**
     * Remove um nodo p retornando o elemento que la estava.
     * 
     * @param p
     * @return
     * @throws InvalidPositionException 
     */
    public E remove(Position<E> p)
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
    public E set(Position<E> p, E e)
            throws IllegalArgumentException;
    
    public Iterable<Position<E>> positions();
    
}
