package datastructure.listanditerator;

/**
 *
 * @author mrl00
 * @param <E>
 */
public interface IndexList<E> {
    /**
     *  
     * @return o numero de elementos nesta lista.
     */
    public int size();
    
    /**
     *  
     * @return se a lista esta vazia.
     */
    public boolean isEmpty();
    
    /**
     * Insere um elemento e de maneira que ele ocupe o indice i, deslocando todos os elementos depois deste.
     * @param indx
     * @param element
     * @throws IndexOutOfBoundsException 
     */
    public void add(int indx, E element) throws IndexOutOfBoundsException;
    
    /**
     * 
     * @param index
     * @return o elemento no indice i sem remove-lo
     * @throws IndexOutOfBoundsException 
     */
    public E get(int index) throws IndexOutOfBoundsException;
    
    /**
     *  
     * @param index
     * @return retorna o elemento no indice i, deslocando os elementos apos este.
     * @throws IndexOutOfBoundsException 
     */
    public E remove(int index) throws IndexOutOfBoundsException;
    
    /**
     * Substitui o elemento no indice i por e, retornando o elemento anterior em i.
     * @param index
     * @param element
     * @return
     * @throws IndexOutOfBoundsException 
     */
    public E set(int index, E element) throws IndexOutOfBoundsException;
}
