package datastructure.lists;

/**
 *
 * @author mrl00
 * @param <E>
 */

@FunctionalInterface
public interface Position<E> {
    /**
     * 
     * @return the element stored in this position.
     */
    E getElement() throws IllegalStateException;
}
