package datastructure.lists;

/**
 *
 * @author mrl00
 * @param <E>
 */
public interface IndexList<E> extends Iterable<E>, Cloneable {
    /**
     *  
     * @return the number of elements on list.
     */
    public int size();
    
    /**
     *  
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty();
    
    /**
     * 
     * @param index
     * @return the element (does not remove) at index i .
     * @throws IndexOutOfBoundsException 
     */
    public E get(int index) throws IndexOutOfBoundsException;
    
    /**
     * 
     * @param index
     * @param element
     * @return
     * @throws IndexOutOfBoundsException 
     */
    public E set(int index, E element) throws IndexOutOfBoundsException;
    
    /**
     * @param indx
     * @param element
     * @throws IndexOutOfBoundsException 
     */
    public void add(int indx, E element) throws IndexOutOfBoundsException;
    
    /**
     *  
     * @param index
     * @return and remove the element at index i.
     * @throws IndexOutOfBoundsException 
     */
    public E remove(int index) throws IndexOutOfBoundsException;
    
    
}
